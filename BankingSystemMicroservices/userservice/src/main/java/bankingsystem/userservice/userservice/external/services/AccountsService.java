package bankingsystem.userservice.userservice.external.services;

import bankingsystem.userservice.userservice.entities.Accounts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ACCOUNT-MANAGEMENT")
public interface AccountsService {

    @GetMapping("/account/{accountId}")
    Accounts getAccounts(@PathVariable("accountId") String accountId);



}
