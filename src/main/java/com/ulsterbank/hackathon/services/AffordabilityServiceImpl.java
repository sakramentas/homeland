package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.*;
import com.ulsterbank.hackathon.domain.wrappers.Transactions;
import org.springframework.stereotype.Service;

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

    private void affordabilityEntryPoint(String accountId) {
        Account account = ulsterBankAPIService.getSingleAccount(accountId);
        Transactions accountTransactions = ulsterBankAPIService.getAccountTransactions(account);

        Double annualGrossSalary = calculateAnnualGrossSalary(accountTransactions);
        //income amount
    }

    private Double calculateAnnualGrossSalary(Transactions transactions) {
        List<Transaction> accountTransactions = transactions.getTransactions();

        for (Transaction transaction : accountTransactions) {
            if (transaction.getTransactionDescription().equalsIgnoreCase("salary")) {
                Double transactionAmount = transaction.getTransactionAmount();
                return (transactionAmount * 12) * 1.5;
            }
        }

        return null;
    }

    @Override
    public Map getAffordability(Customer customer) {
        Account account = ulsterBankAPIService.getSingleAccount(customer.getAccount().getId());
        Transactions transactions = ulsterBankAPIService.getAccountTransactions(account);
        Double totalOfExtraIncomes = getTotalOfExtraIncomes(customer.getExtraIncomes());
        List<Property> properties = propertiesAPIService.getProperties();
        customer.setAnnualGrossSalary(calculateAnnualGrossSalary(transactions));

        updatePropertiesAccordingToAffordability(customer, properties, totalOfExtraIncomes);

        Map<String, Object> customerAndProperties = new LinkedHashMap<>();

        customerAndProperties.put("customer", customer);
        customerAndProperties.put("properties", properties);

        return customerAndProperties;
    }

    private void updatePropertiesAccordingToAffordability(Customer customer, List<Property> properties, Double totalOfExtraIncomes){
        Double accountBalance = customer.getAccount().getAccountBalance();

        if (customer.isFirstTimeBuyer()) {
            for (Property property : properties) {
                double tenPercent = property.getPrice().doubleValue() * 0.1;
                addFlagsToProperties(customer, totalOfExtraIncomes, accountBalance, property, tenPercent);
            }
        } else {
            for (Property property : properties) {
                double twentyPercent = property.getPrice().doubleValue() * 0.2;
                addFlagsToProperties(customer, totalOfExtraIncomes, accountBalance, property, twentyPercent);
            }
        }
    }

    private void addFlagsToProperties(Customer customer, Double totalOfExtraIncomes, Double accountBalance, Property property, double percentage) {
        double totalCredit = (customer.getAnnualGrossSalary() + totalOfExtraIncomes) * 3.5;

        if (accountBalance >= percentage) {
            if (totalCredit >= property.getPrice()) {
                property.setAffordabilityStatus("green");
            } else {
                property.setAffordabilityStatus("red");
            }
        } else {
            property.setAffordabilityStatus("red");
        }
    }

    private Double getTotalOfExtraIncomes(List<Double> extraIncomes){
        return extraIncomes.stream().mapToDouble(Double::doubleValue).sum();
    }
}
