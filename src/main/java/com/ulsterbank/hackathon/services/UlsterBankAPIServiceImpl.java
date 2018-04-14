package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Account;
import com.ulsterbank.hackathon.domain.AccountsWrapper;
import com.ulsterbank.hackathon.domain.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    public AccountsWrapper getWrapper() {
        String apiCustomerId = getCustomerId();
        String customersUrl = baseURL + "/customers/" + apiCustomerId + "/accounts";
        ResponseEntity<AccountsWrapper> results = restTemplate.exchange(customersUrl, HttpMethod.GET, addRequestHeaders(), AccountsWrapper.class);

        AccountsWrapper accounts = results.getBody();

        return accounts;
    }

    private String getCustomerId(){
        String customersUrl = baseURL + "/customers";
        ResponseEntity<AccountsWrapper> results = restTemplate.exchange(customersUrl, HttpMethod.GET, addRequestHeaders(), AccountsWrapper.class);
        AccountsWrapper customers = results.getBody();
        String apiCustomer = customers.getAccounts().get(0).getId();

        return apiCustomer;
    }

    @Override
    public Account getSingleAccount(String accountId){
        String singleAccountUrl = baseURL + "/accounts/" + accountId;
        ResponseEntity<Account> results = restTemplate.exchange(singleAccountUrl, HttpMethod.GET, addRequestHeaders(), Account.class);
        Account account = results.getBody();

        return account;
    }

    @Override
    public List<Transaction> getAccountTransactions(Account account) {
        return null;
    }


    private HttpEntity<String> addRequestHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(devRequestHeader, devToken);
        httpHeaders.set(bearerRequestHeader, bearerToken);

        HttpEntity<String> requestHeaders = new HttpEntity<>("parameters", httpHeaders);

        return requestHeaders;
    }

}
