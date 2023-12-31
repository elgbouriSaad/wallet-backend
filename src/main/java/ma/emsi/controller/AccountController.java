package ma.emsi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.emsi.model.Account;
import ma.emsi.model.Objective;
import ma.emsi.model.Transaction;
import ma.emsi.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {
        try {
            Account createdAccount = accountService.createAccount(account);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccountById(@PathVariable int accountId) {
        try {
            Account account = accountService.getAccountById(accountId);
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<?> getTransactionsForAccount(@PathVariable int accountId) {
        try {
            List<Transaction> transactions = accountService.getTransactionsForAccount(accountId);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{accountId}/objectives")
    public ResponseEntity<?> getObjectivesForAccount(@PathVariable int accountId) {
        try {
            List<Objective> objectives = accountService.getObjectivesForAccount(accountId);
            return ResponseEntity.ok(objectives);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<?> updateAccount(@PathVariable int accountId, @Valid @RequestBody Account updatedAccount) {
        try {
            Account account = accountService.updateAccount(accountId, updatedAccount);
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int accountId) {
        try {
            accountService.deleteAccount(accountId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
