package com.meetnplay.accountservice.com.meetnplay.accountservice.model.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountController {

    @Autowired private AccountCollection accountCollection;

    public void create(AccountDTO accountDTO) {
        accountCollection.insert(accountDTO.toEntity());
    }

    public Iterable<Account> getAll() {
        return accountCollection.getAll();
    }

    public void delete(long id) {
        accountCollection.remove(id);
    }

    public Long getAccountIdByName(String name){
        return accountCollection.getAccountIdByName(name);
    }
}
