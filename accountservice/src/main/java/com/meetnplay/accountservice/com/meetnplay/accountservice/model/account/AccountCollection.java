package com.meetnplay.accountservice.com.meetnplay.accountservice.model.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCollection {

    @Autowired private IAccountRepository repository;

    public void insert(Account account) {
        repository.insert(account);
    }

    public void remove(Long id) {
        repository.remove(id);
    }

    public Iterable<Account> getAll() {
        return repository.getAll();
    }

    public Account get(Long id) {
        return repository.get(id);
    }

    public Long getAccountIdByName(String name){
        return repository.getByName(name);
    }
}
