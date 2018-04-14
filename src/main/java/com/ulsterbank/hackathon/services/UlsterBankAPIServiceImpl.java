package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.AccountsWrapper;
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

    public AccountsWrapper getAccounts() {
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

    private HttpEntity<String> addRequestHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(devRequestHeader, devToken);
        httpHeaders.set(bearerRequestHeader, bearerToken);

        HttpEntity<String> requestHeaders = new HttpEntity<>("parameters", httpHeaders);

        return requestHeaders;
    }

}
