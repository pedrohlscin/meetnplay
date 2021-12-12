package com.meetnplay.accountservice.com.meetnplay.accountservice.communication;


import com.meetnplay.accountservice.com.meetnplay.accountservice.model.account.Account;
import com.meetnplay.accountservice.com.meetnplay.accountservice.model.account.AccountController;
import com.meetnplay.accountservice.com.meetnplay.accountservice.model.account.AccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/account")
@Slf4j
public class AccountMVCController {

    @Autowired private AccountController controller;

    @Value("${login_service_url}")
    private String loginUrl;

    @ModelAttribute("loginUrl")
    private String getLoginUrl(){
        return loginUrl;
    }

    @Value("${base_url}")
    private String baseUrl;

    @ModelAttribute("baseUrl")
    public String getUrl() {
        return this.baseUrl;
    }

    @GetMapping("")
    public String getAccounts(Model model) {
        model.addAttribute("accounts", controller.getAll());
        return "accounts";
    }

    @GetMapping("/form")
    public String getAccountForm() {
        return "account_form";
    }

    @PostMapping("/form")
    public String newAccount(@ModelAttribute AccountDTO accountDTO) throws URISyntaxException {
        controller.create(accountDTO);
        Long accountId = controller.getAccountIdByName(accountDTO.getName());
        String urlMethod = loginUrl + "/login/createLogin";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("accountId", accountId.toString());
        map.add("password", accountDTO.getPassword());

        URI url = new URI(urlMethod);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(map, headers);
        ResponseEntity<Boolean> b = null;

        b = new RestTemplate().postForEntity(url, requestEntity, Boolean.class);

        log.info("Return of the login api: " + b);
        return "redirect:/account";
    }

    @PostMapping("/delete")
    public String deleteAccount(@RequestParam(name = "accountId") String accountId){
        controller.delete(Long.parseLong(accountId));
        return "redirect:/account";
    }

}