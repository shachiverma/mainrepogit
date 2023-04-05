package bankingsystem.userservice.userservice.external.services;

import bankingsystem.userservice.userservice.entities.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "CUSTOMER-ACCOUNT-BANK")
public interface AccountService {

    @PostMapping("/linkaccountcustomers")
    public ResponseEntity<Account> createLink(Account values);


    //PUT
    @PutMapping("/linkaccountcustomers/{accountSystemId}")
    public ResponseEntity<Account> updateLink(@PathVariable("accountSystemId") String accountSystemId, Account account);


    @DeleteMapping("/linkaccountcustomers/{accountSystemId}")
    public void deleteRating(@PathVariable String accountSystemId);
}
