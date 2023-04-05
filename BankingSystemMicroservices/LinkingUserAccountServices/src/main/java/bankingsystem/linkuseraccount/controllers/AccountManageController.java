package bankingsystem.linkuseraccount.controllers;

import bankingsystem.linkuseraccount.entities.AccountManage;
import bankingsystem.linkuseraccount.services.AccountManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linkaccountcustomers")
public class AccountManageController {

    @Autowired
    private AccountManageService accountManageService;

    //createlink
    @PostMapping()
    public ResponseEntity<AccountManage> create(@RequestBody AccountManage accountManage){

        return ResponseEntity.status(HttpStatus.CREATED).body(accountManageService.create(accountManage));
    }

    //getAll
    @GetMapping()
    public ResponseEntity<List<AccountManage>> getAllAccounts(){
        return ResponseEntity.ok(accountManageService.getAllAccounts());
    }

    //getByCustomerId
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<AccountManage>> getByCustomerId(@PathVariable String customerId){
        return ResponseEntity.ok(accountManageService.getAllByCustomerId(customerId));
    }
}
