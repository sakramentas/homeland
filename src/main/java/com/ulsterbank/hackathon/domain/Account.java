package com.ulsterbank.hackathon.domain;

public class Account {

    private String id;
    private String sortCode;
    private String accountNumber;
    private String iBan;
    private String bBan;
    private String accountType;
    private String accountFriendlyName;
    private Double accountBalance;
    private String accountCurrency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getiBan() {
        return iBan;
    }

    public void setiBan(String iBan) {
        this.iBan = iBan;
    }

    public String getbBan() {
        return bBan;
    }

    public void setbBan(String bBan) {
        this.bBan = bBan;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountFriendlyName() {
        return accountFriendlyName;
    }

    public void setAccountFriendlyName(String accountFriendlyName) {
        this.accountFriendlyName = accountFriendlyName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
}
