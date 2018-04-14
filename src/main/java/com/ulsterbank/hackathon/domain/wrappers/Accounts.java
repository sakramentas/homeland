package com.ulsterbank.hackathon.domain.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ulsterbank.hackathon.domain.Account;

import java.util.List;

public class Accounts {

    @JsonProperty("results")
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
