package com.ulsterbank.hackathon.controllers;

import com.ulsterbank.hackathon.domain.AccountsWrapper;
import com.ulsterbank.hackathon.domain.Property;
import com.ulsterbank.hackathon.services.PropertiesAPIService;
import com.ulsterbank.hackathon.services.UlsterBankAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/homeland/api")
public class APIController {

    private UlsterBankAPIService ulsterBankAPIService;
    private PropertiesAPIService propertiesAPIService;

    @Autowired
    public APIController(UlsterBankAPIService ulsterBankAPIService, PropertiesAPIService propertiesAPIService) {
        this.ulsterBankAPIService = ulsterBankAPIService;
        this.propertiesAPIService = propertiesAPIService;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<Object, Object> accounts() {
        AccountsWrapper accounts = ulsterBankAPIService.getAccounts();
        Map accountTagAndAccounts = new HashMap<>();
        accountTagAndAccounts.put("accounts", accounts.getAccounts());
        return accountTagAndAccounts;
    }

    @RequestMapping(value = "/properties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<Object, Object> properties(){
        List<Property> properties = propertiesAPIService.getProperties();
        Map propertyTagAndProperties = new HashMap<>();
        propertyTagAndProperties.put("properties", properties);
        return propertyTagAndProperties;
    }
}
