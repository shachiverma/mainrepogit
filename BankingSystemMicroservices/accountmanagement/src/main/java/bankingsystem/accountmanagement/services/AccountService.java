package bankingsystem.accountmanagement.services;

import bankingsystem.accountmanagement.entities.Accounts;

import java.util.List;

public interface AccountService {

    //create
    Accounts create(Accounts accounts);

    //getAllAccounts
    List<Accounts> getAll();

    //getSingle
    Accounts get(String id);
}
