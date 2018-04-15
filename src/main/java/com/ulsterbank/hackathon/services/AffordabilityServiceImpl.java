package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Account;
import com.ulsterbank.hackathon.domain.Customer;
import com.ulsterbank.hackathon.domain.Property;
import com.ulsterbank.hackathon.domain.Transaction;
import com.ulsterbank.hackathon.domain.wrappers.Transactions;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AffordabilityServiceImpl implements AffordabilityService {

    private UlsterBankAPIService ulsterBankAPIService;
    private PropertiesAPIService propertiesAPIService;

    public AffordabilityServiceImpl(UlsterBankAPIService ulsterBankAPIService, PropertiesAPIService propertiesAPIService) {
        this.ulsterBankAPIService = ulsterBankAPIService;
        this.propertiesAPIService = propertiesAPIService;
    }

    private BigDecimal calculateAnnualGrossSalary(Transactions transactions) {
        List<Transaction> accountTransactions = transactions.getTransactions();

        for (Transaction transaction : accountTransactions) {
            if (transaction.getTransactionDescription().equalsIgnoreCase("salary")) {
                Double transactionAmount = transaction.getTransactionAmount();
                return new BigDecimal((transactionAmount * 12) * 1.5).setScale(3, RoundingMode.HALF_UP);
            }
        }

        return null;
    }

    @Override
    public Map getAffordability(Customer customer) {
        Account account = ulsterBankAPIService.getSingleAccount(customer.getAccount().getId());
        Transactions transactions = ulsterBankAPIService.getAccountTransactions(account);
        BigDecimal totalOfExtraIncomes = getTotalOfExtraIncomes(customer.getExtraIncomes());
        List<Property> properties = propertiesAPIService.getProperties();
        customer.setAnnualGrossSalary(calculateAnnualGrossSalary(transactions));

        updatePropertiesAccordingToAffordability(customer, properties, totalOfExtraIncomes);

        Map<String, Object> customerAndProperties = new LinkedHashMap<>();

        customerAndProperties.put("customer", customer);
        customerAndProperties.put("properties", properties);

        return customerAndProperties;
    }

    private void updatePropertiesAccordingToAffordability(Customer customer, List<Property> properties, BigDecimal totalOfExtraIncomes) {
        BigDecimal accountBalance = customer.getAccount().getAccountBalance();

        if (customer.isFirstTimeBuyer()) {
            for (Property property : properties) {
                BigDecimal tenPercent = new BigDecimal(property.getPrice().doubleValue() * 0.1);
                addFlagsToProperties(customer, totalOfExtraIncomes, accountBalance, property, tenPercent);
            }
        } else {
            for (Property property : properties) {
                BigDecimal twentyPercent = new BigDecimal(property.getPrice().doubleValue() * 0.2);
                addFlagsToProperties(customer, totalOfExtraIncomes, accountBalance, property, twentyPercent);
            }
        }
    }

    private void addFlagsToProperties(Customer customer, BigDecimal totalOfExtraIncomes, BigDecimal accountBalance, Property property, BigDecimal propertyPercentageValue) {
        BigDecimal totalCredit = new BigDecimal(customer.getAnnualGrossSalary().add(totalOfExtraIncomes).doubleValue() * 3.5);

        if (accountBalance.compareTo(propertyPercentageValue) > 0) {
            if (totalCredit.compareTo(property.getPrice()) > 0) {
                property.setAffordabilityStatus("green");
            } else {
                property.setAffordabilityStatus("red");
            }
        } else {
            property.setAffordabilityStatus("red");
        }
    }

    private BigDecimal getTotalOfExtraIncomes(List<BigDecimal> extraIncomes) {
        return BigDecimal.valueOf(extraIncomes.stream().mapToDouble(BigDecimal::doubleValue).sum());
    }
}
