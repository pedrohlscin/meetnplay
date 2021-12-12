package com.meetnplay.loginservice.model.login;

import org.springframework.data.repository.CrudRepository;

public interface LoginDao extends CrudRepository<Login, Long> {
}
