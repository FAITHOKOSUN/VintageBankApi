package com.bankmgt.demo.service;

import com.bankmgt.demo.entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountDetailsByAccountName(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(Long accountNumber, Double amount);
    public Account withdrawAmount(Long accountNumber,double amount);
    public void closeAccount(Long accountNumber);
}
