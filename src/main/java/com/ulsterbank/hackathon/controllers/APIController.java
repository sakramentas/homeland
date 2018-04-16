package com.ulsterbank.hackathon.controllers;

import com.ulsterbank.hackathon.domain.Account;
import com.ulsterbank.hackathon.domain.Customer;
import com.ulsterbank.hackathon.domain.Property;
import com.ulsterbank.hackathon.domain.wrappers.Accounts;
import com.ulsterbank.hackathon.services.AffordabilityService;
import com.ulsterbank.hackathon.services.PropertiesAPIService;
import com.ulsterbank.hackathon.services.UlsterBankAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/homeland/api")
@CrossOrigin(origins = "*")
public class APIController {

    private UlsterBankAPIService ulsterBankAPIService;
    private PropertiesAPIService propertiesAPIService;
    private AffordabilityService affordabilityService;

    @Autowired
    public APIController(UlsterBankAPIService ulsterBankAPIService, PropertiesAPIService propertiesAPIService, AffordabilityService affordabilityService) {
        this.ulsterBankAPIService = ulsterBankAPIService;
        this.propertiesAPIService = propertiesAPIService;
        this.affordabilityService = affordabilityService;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<Object, Object> accounts() {
        Accounts accounts = ulsterBankAPIService.getWrapper();
        Map accountTagAndAccounts = new HashMap<>();
        accountTagAndAccounts.put("accounts", accounts.getAccounts());
        return accountTagAndAccounts;
    }

    @RequestMapping(value = "/properties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<Object, Object> properties() {
        List<Property> properties = propertiesAPIService.getProperties();
        Map propertyTagAndProperties = new HashMap<>();
        propertyTagAndProperties.put("properties", properties);
        return propertyTagAndProperties;
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Account singleAccount(@PathVariable("accountId") String id) {
        Account account = new Account();
        account.setId("1d7de9d2-7129-492d-b505-0e4aa4775294");
        account.setSortCode("839999");
        account.setAccountNumber("10002343");
        account.setiBan(null);
        account.setbBan(null);
        account.setAccountType("current");
        account.setAccountFriendlyName("Allan Current Account");
        account.setAccountBalance(new BigDecimal(669.62));

        return account;
//        try {
//            return ulsterBankAPIService.getSingleAccount(id);
//        } catch (HttpClientErrorException e) {
//            return ulsterBankAPIService.getSingleAccount("1d7de9d2-7129-492d-b505-0e4aa4775294");
//        }
    }

    @RequestMapping(value = "/affordability")
    public Map affordability(@RequestParam Map<String, String> queryStringMap) {
        try {
            Customer customer = buildCustomer(queryStringMap);
            return affordabilityService.getAffordability(customer);
        } catch (HttpClientErrorException e) {
            return new HashMap();
        }
    }

    private Customer buildCustomer(Map<String, String> queryStringMap) {
        Customer customer = ulsterBankAPIService.getCustomer(null);

        String accountId = queryStringMap.get("accountid");
        String extraIncome = queryStringMap.get("extraincome");
        boolean firstTimeBuyer = Boolean.valueOf(queryStringMap.get("firsttimebuyer"));

        if (extraIncome != null) {
            String[] extraIncomes = extraIncome.split(",");
            if (extraIncomes.length > 0) {
                for (String income : extraIncomes) {
                    customer.getExtraIncomes().add(new BigDecimal(income));
                }
            }
        }

        Account customerAccount = singleAccount(accountId);
        customer.setAccount(customerAccount);
        customer.setFirstTimeBuyer(firstTimeBuyer);

        return customer;
    }
}
