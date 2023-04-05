package bankingsystem.linkuseraccount.services.impl;

import bankingsystem.linkuseraccount.entities.AccountManage;
import bankingsystem.linkuseraccount.repositories.AccountManageRepository;
import bankingsystem.linkuseraccount.services.AccountManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountManageServiceImpl implements AccountManageService {

    @Autowired
    private AccountManageRepository accountManageRepository;


    @Override
    public AccountManage create(AccountManage accountManage) {
        return accountManageRepository.save(accountManage);
    }

    @Override
    public List<AccountManage> getAllAccounts() {
        return accountManageRepository.findAll();
    }

    @Override
    public List<AccountManage> getAllByCustomerId(String customerId) {
        return accountManageRepository.findByCustomerId(customerId);
    }
}
