package ma.emsi.controller;

import lombok.AllArgsConstructor;
import ma.emsi.service.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/v1/transaction")
@RestController
public class TransactionController {

    private final TransactionService transactionService;
}
