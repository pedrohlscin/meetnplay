package com.meetnplay.accountservice.com.meetnplay.accountservice.communication;


import com.meetnplay.accountservice.com.meetnplay.accountservice.model.account.AccountController;
import com.meetnplay.accountservice.com.meetnplay.accountservice.model.account.AccountDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
@Slf4j
public class AccountMVCController {

    @Autowired private AccountController controller;

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
    public String newAccount(@ModelAttribute AccountDTO accountDTO) {
        controller.create(accountDTO);
        return "redirect:/account";
    }

}