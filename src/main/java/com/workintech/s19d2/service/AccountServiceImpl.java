package com.workintech.s19d2.service;

import com.workintech.s19d2.dao.AccountRepository;
import com.workintech.s19d2.entity.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            return optionalAccount.get();
        }
        throw new RuntimeException("Account is not found with id: " + id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }
}
