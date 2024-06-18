package com.bankmgt.demo.controller;

import com.bankmgt.demo.entity.Account;
import com.bankmgt.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    //create account
    @Autowired
    AccountService service;
    @PostMapping("/create")
    //public Account createAccount(@RequestBody Account account)
    public ResponseEntity<Account> createAccount(@RequestBody Account account)
    {
        Account createAccount = service.createAccount(account);
        //return createAccount;
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }
    @GetMapping("/{accountNumber}")
    public Account getAccountDetailsByAccountName(@PathVariable Long accountNumber){
       Account account = service.getAccountDetailsByAccountName(accountNumber) ;
        return account;

    }

    @GetMapping("/getAllAccount")
    public List<Account> getAllAccountDetails()
    {
       List<Account> allacc =  service.getAllAccountDetails();
       return allacc;
    }
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAccount(@PathVariable Long accountNumber, @PathVariable Double amount)
    {
        Account account = service.depositAmount(accountNumber, amount);
        return account;
    }
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount)
    {
        Account account = service.withdrawAmount(accountNumber, amount);
        return account;
    }
@DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber)
{
    service.closeAccount(accountNumber);
    return ResponseEntity.ok("Account closed");
}


}
