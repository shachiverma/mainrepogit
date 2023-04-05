package bankingsystem.accountmanagement.services.impl;

import bankingsystem.accountmanagement.entities.Accounts;
import bankingsystem.accountmanagement.exceptions.ResourceNotFoundException;
import bankingsystem.accountmanagement.repositories.AccountRepository;
import bankingsystem.accountmanagement.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Accounts create(Accounts accounts) {
        String id = UUID.randomUUID().toString();
        accounts.setId(id);
        return accountRepository.save(accounts);
    }

    @Override
    public List<Accounts> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Accounts get(String id) {
        return accountRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Account with given Id not found")
        );
    }
}
