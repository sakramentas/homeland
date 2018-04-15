package com.ulsterbank.hackathon.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String id;
    private String givenName;
    private String familyName;
    private String address1;
    private String town;
    private String county;
    private String postCode;
    private String country;
    private String mobilePhone;
    private boolean firstTimeBuyer;
    private BigDecimal annualGrossSalary;
    private List<BigDecimal> extraIncomes = new ArrayList<>();
    private Account account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public boolean isFirstTimeBuyer() {
        return firstTimeBuyer;
    }

    public void setFirstTimeBuyer(boolean firstTimeBuyer) {
        this.firstTimeBuyer = firstTimeBuyer;
    }

    public BigDecimal getAnnualGrossSalary() {
        return annualGrossSalary;
    }

    public void setAnnualGrossSalary(BigDecimal annualGrossSalary) {
        this.annualGrossSalary = annualGrossSalary;
    }

    public List<BigDecimal> getExtraIncomes() {
        return extraIncomes;
    }

    public void setExtraIncomes(List<BigDecimal> extraIncomes) {
        this.extraIncomes = extraIncomes;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
