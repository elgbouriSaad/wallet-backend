package ma.emsi.controller;

import lombok.AllArgsConstructor;
import ma.emsi.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @RequestMapping("/add")
    public void addAccount() {
    System.out.println("hello");
    }
}
