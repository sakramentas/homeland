package com.ulsterbank.hackathon.services;

import com.ulsterbank.hackathon.domain.Account;
import com.ulsterbank.hackathon.domain.wrappers.Accounts;
import com.ulsterbank.hackathon.domain.wrappers.Transactions;

public interface UlsterBankAPIService {

    Accounts getWrapper();

    Account getSingleAccount(String accountId);

    Transactions getAccountTransactions(Account account);
}
