package com.meetnplay.accountservice.com.meetnplay.accountservice.model.account;

import lombok.Value;

@Value
public class AccountDTO {
    private String name;
    private String password;

    public Account toEntity() {
        return Account.builder().name(name).password(password).build();
    }
}
