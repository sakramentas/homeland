package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Account;
import com.ulsterbank.hackathon.domain.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffordabilityServiceImpl implements AffordabilityService {

    private UlsterBankAPIService ulsterBankAPIService;
    private PropertiesAPIService propertiesAPIService;

    public AffordabilityServiceImpl(UlsterBankAPIService ulsterBankAPIService, PropertiesAPIService propertiesAPIService) {
        this.ulsterBankAPIService = ulsterBankAPIService;
        this.propertiesAPIService = propertiesAPIService;
    }

    private void calculateLoanToValue(){
        List<Account> accounts = ulsterBankAPIService.getWrapper().getAccounts();
        List<Property> properties = propertiesAPIService.getProperties();



    }
}
