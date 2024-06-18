package com.bankmgt.demo.service;


import com.bankmgt.demo.entity.Account;
import com.bankmgt.demo.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
@Autowired
    AccountRepository repo;
    @Override
    public Account createAccount(Account account) {
       Account account_saved  = repo.save(account);

        return account_saved;
    }

    @Override
    public Account getAccountDetailsByAccountName(Long accountNumber) {
      Optional<Account> account = repo.findById(accountNumber);
      if (account.isEmpty())
      {
          throw new RuntimeException("Account not available");

      }
      Account account_found = account.get();
      return account_found;

    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> getAll = repo.findAll();

        return getAll;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
      Optional<Account> account = repo.findById(accountNumber);
        if (account.isEmpty())
        {
            throw new RuntimeException("no money");

        }
        Account account_present = account.get();
       Double totalBalance =  account_present.getAccount_balance()+amount;
        account_present.setAccount_balance(totalBalance);
        repo.save(account_present);
        return account_present;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, double amount) {
        Optional<Account> account = repo.findById(accountNumber);
        if (account.isEmpty())
        {
            throw new RuntimeException("no money");

        }
        Account account_present = account.get();
        Double account_balance = account_present.getAccount_balance()-amount;
        account_present.setAccount_balance(account_balance);
       repo.save(account_present);
        return account_present;

    }

    @Override
    public void closeAccount(Long accountNumber) {
        repo.deleteById(accountNumber);

    }
}
