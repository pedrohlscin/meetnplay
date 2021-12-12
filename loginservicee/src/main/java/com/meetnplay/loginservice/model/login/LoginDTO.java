package com.meetnplay.loginservice.model.login;

import lombok.Value;

@Value
public class LoginDTO {
    private Long accountId;
    private String password;

    public Login toEntity(){
        return Login.builder().accountId(accountId).password(password).build();
    }
}
