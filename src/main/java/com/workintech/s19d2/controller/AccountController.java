package com.workintech.s19d2.controller;

import com.workintech.s19d2.entity.Account;
import com.workintech.s19d2.service.AccountService;
import com.workintech.s19d2.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> findAll(){
        List<Account> accountList = accountService.findAll();
        return accountList;
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable long id){
        return accountService.findById(id);
    }

    @PostMapping
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account update(@RequestBody Account account, @PathVariable long id){
        account.setId(id);
        accountService.save(account);
        return account;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        Account account = accountService.findById(id);
        accountService.delete(account);
    }
}
