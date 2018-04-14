package com.ulsterbank.hackathon.controllers;

import com.ulsterbank.hackathon.domain.CustomersWrapper;
import com.ulsterbank.hackathon.services.UlsterBankAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/homeland/api")
public class APIController {

    private UlsterBankAPIService ulsterBankAPIService;

    @Autowired
    public APIController(UlsterBankAPIService ulsterBankAPIService) {
        this.ulsterBankAPIService = ulsterBankAPIService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public HashMap<Object, Object> customers() {
        CustomersWrapper customers = ulsterBankAPIService.getCustomers();
        HashMap<Object, Object> customerAndList = new HashMap<>();
        customerAndList.put("customers", customers.getCustomers());
        return customerAndList;
    }
}
