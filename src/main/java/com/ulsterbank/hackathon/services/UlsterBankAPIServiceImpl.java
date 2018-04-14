package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.CustomersWrapper;
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

    public CustomersWrapper getCustomers() {
        String customersUrl = baseURL + "/customers";
        ResponseEntity<CustomersWrapper> results = restTemplate.exchange(customersUrl, HttpMethod.GET, addRequestHeaders(), CustomersWrapper.class);

        CustomersWrapper customers = results.getBody();

        return customers;
    }

    private HttpEntity<String> addRequestHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(devRequestHeader, devToken);
        httpHeaders.set(bearerRequestHeader, bearerToken);

        HttpEntity<String> requestHeaders = new HttpEntity<>("parameters", httpHeaders);

        return requestHeaders;
    }

}
