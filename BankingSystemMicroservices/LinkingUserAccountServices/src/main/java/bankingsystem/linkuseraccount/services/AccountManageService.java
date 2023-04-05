package bankingsystem.linkuseraccount.services;

import bankingsystem.linkuseraccount.entities.AccountManage;

import java.util.List;

public interface AccountManageService {

    //create

    AccountManage  create(AccountManage accountManage);

    //getAllAccounts

    List<AccountManage> getAllAccounts();

    //getAllByCustomerID
    List<AccountManage> getAllByCustomerId(String customerId);

}
