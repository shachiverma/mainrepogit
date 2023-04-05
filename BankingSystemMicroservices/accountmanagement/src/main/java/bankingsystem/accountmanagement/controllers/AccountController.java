package bankingsystem.accountmanagement.controllers;

import bankingsystem.accountmanagement.entities.Accounts;
import bankingsystem.accountmanagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    //deposit
    @PostMapping()
    public ResponseEntity<Accounts> deposit(@RequestBody Accounts accounts){

        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(accounts));
    }
    //withdrawnAmount
//    @PostMapping()
//    public ResponseEntity<Accounts> withdraw(@RequestBody Accounts accounts){
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(accounts));
//    }
    //currentBalance
//    @GetMapping("/{id}")
//    public ResponseEntity<Accounts> addAmount(@PathVariable String id){
//
//        return ResponseEntity.status(HttpStatus.OK).body(accountService.get(id));
//
//    }
    //deleteAccount
    //getAccountDetails
    @GetMapping("/{id}")
    public ResponseEntity<Accounts> deposit(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.get(id));
    }



}
