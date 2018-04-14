package com.ulsterbank.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomersWrapper {

    @JsonProperty("results")
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
