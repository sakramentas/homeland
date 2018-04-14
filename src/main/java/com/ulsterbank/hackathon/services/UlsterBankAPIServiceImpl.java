package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Account;
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

    private String getCustomerId() {
        String customersUrl = baseURL + "/customers";
        ResponseEntity<Accounts> results = restTemplate.exchange(customersUrl, HttpMethod.GET, addRequestHeaders(), Accounts.class);
        Accounts customers = results.getBody();
        String apiCustomer = customers.getAccounts().get(0).getId();

        return apiCustomer;
    }

    @Override
    public Account getSingleAccount(String accountId) {
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
