package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Customer;

import java.util.Map;

public interface AffordabilityService {

    Map getAffordability(Customer customer);

}
