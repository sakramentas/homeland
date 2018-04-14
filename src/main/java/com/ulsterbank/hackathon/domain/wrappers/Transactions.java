package com.ulsterbank.hackathon.domain.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulsterbank.hackathon.domain.Transaction;

import java.util.List;

public class Transactions {

    @JsonProperty("results")
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
