package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Account;
import com.ulsterbank.hackathon.domain.Customer;
import com.ulsterbank.hackathon.domain.wrappers.Accounts;
import com.ulsterbank.hackathon.domain.wrappers.Transactions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UlsterBankAPIServiceImpl implements UlsterBankAPIService {

    @Value("${api.ulster.tokens.dev.header}")
    private String devRequestHeader;

    @Value("${api.ulster.tokens.dev.key}")
    private String devToken;

    @Value("${api.ulster.tokens.bearer.header}")
    private String bearerRequestHeader;

    @Value("${api.ulster.tokens.bearer.key}")
    private String bearerToken;

    @Value("${api.ulster.baseurl}")
    private String baseURL;

    private RestTemplate restTemplate;

    public UlsterBankAPIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Accounts getWrapper() {
        String apiCustomerId = getCustomerId();
        String customersUrl = baseURL + "/customers/" + apiCustomerId + "/accounts";
        ResponseEntity<Accounts> results = restTemplate.exchange(customersUrl, HttpMethod.GET, addRequestHeaders(), Accounts.class);

        Accounts accounts = results.getBody();

        return accounts;
    }

    @Override
    public Customer getCustomer(String customerId) {
//        if (customerId == null) {
////            customerId = getCustomerId();
////        }
////
////        String customerUrl = baseURL + "/customers/" + customerId;
////        ResponseEntity<Customer> results = restTemplate.exchange(customerUrl, HttpMethod.GET, addRequestHeaders(), Customer.class);
////        Customer customer = results.getBody();

        Customer mockCustomer = new Customer();
        mockCustomer.setId("95e9972e-5b1b-4614-93b1-f546c6a89e4b");
        mockCustomer.setGivenName("Allan");
        mockCustomer.setFamilyName("Haerber");
        mockCustomer.setAddress1("O'Connel Street");
        mockCustomer.setTown("Dublin");
        mockCustomer.setCounty("Dublin");
        mockCustomer.setPostCode("D04HJ66");
        mockCustomer.setFirstTimeBuyer(false);
        return mockCustomer;
    }

    private String getCustomerId() {
        return "95e9972e-5b1b-4614-93b1-f546c6a89e4b";
//        String customersUrl = baseURL + "/customers";
//        ResponseEntity<Accounts> results = restTemplate.exchange(customersUrl, HttpMethod.GET, addRequestHeaders(), Accounts.class);
//        Accounts customers = results.getBody();
//        String apiCustomer = customers.getAccounts().get(0).getId();
//
//        return apiCustomer;
    }

    @Override
    public Account getSingleAccount(String accountId) {
        if (accountId == null) {
            accountId = "fa9df4d3-93bb-449a-9ee8-45b4c98d34b4";
        }

        String singleAccountUrl = baseURL + "/accounts/" + accountId;
        ResponseEntity<Account> results = restTemplate.exchange(singleAccountUrl, HttpMethod.GET, addRequestHeaders(), Account.class);
        Account account = results.getBody();

        return account;
    }

    @Override
    public Transactions getAccountTransactions(Account account) {
        String accountTransactions = baseURL + "/accounts/" + account.getId() + "/transactions";
        ResponseEntity<Transactions> results = restTemplate.exchange(accountTransactions, HttpMethod.GET, addRequestHeaders(), Transactions.class);
        Transactions transactions = results.getBody();

        return transactions;
    }


    private HttpEntity<String> addRequestHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(devRequestHeader, devToken);
        httpHeaders.set(bearerRequestHeader, bearerToken);

        HttpEntity<String> requestHeaders = new HttpEntity<>("parameters", httpHeaders);

        //TODO customer object / annual gross salary / marital status

        return requestHeaders;
    }

}
