package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Account;
import com.ulsterbank.hackathon.domain.AccountsWrapper;
import com.ulsterbank.hackathon.domain.Transaction;

import java.util.List;

public interface UlsterBankAPIService {

    AccountsWrapper getWrapper();

    Account getSingleAccount(String accountId);

    List<Transaction> getAccountTransactions(Account account);
}
