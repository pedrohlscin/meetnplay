package com.meetnplay.accountservice.com.meetnplay.accountservice.model.account;

import org.springframework.data.repository.CrudRepository;

public interface AccountDAO extends CrudRepository<Account, Long> {
    Account getAccountByName(String name);
}
