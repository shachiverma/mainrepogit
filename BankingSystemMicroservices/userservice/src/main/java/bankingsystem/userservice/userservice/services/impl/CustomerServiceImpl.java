package bankingsystem.userservice.userservice.services.impl;

import bankingsystem.userservice.userservice.entities.Account;
import bankingsystem.userservice.userservice.entities.Accounts;
import bankingsystem.userservice.userservice.entities.Customer;
import bankingsystem.userservice.userservice.exceptions.ResourceNotFoundException;
import bankingsystem.userservice.userservice.external.services.AccountService;
import bankingsystem.userservice.userservice.external.services.AccountsService;
import bankingsystem.userservice.userservice.repositories.CustomerRepository;
import bankingsystem.userservice.userservice.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {



    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccountsService accountsService;

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public Customer saveCustomer(Customer customer) {
        String randomCustomerId = UUID.randomUUID().toString();
        customer.setCustomerId(randomCustomerId);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(String customerId) {
        Customer customer =  customerRepository.findById(customerId).orElseThrow(
                ()-> new ResourceNotFoundException("Customer with given " +
                        "Id is not found on server")

        );
        //fetch account details of the customer
        //http://localhost:8083/linkaccountcustomers/customers/14c3935c-363d-48f2-8d27-85bb3e9d25c0

        Account[] bank = restTemplate.getForObject("http://CUSTOMER-ACCOUNT-BANK/linkaccountcustomers/customers/"+customer.getCustomerId(), Account[].class);
        logger.info("{}",bank);

        List<Account> accounts = Arrays.stream(bank).toList();

        List<Account> accountList = accounts.stream().map(account -> {

          //http://localhost:8082/account

          Accounts accounts1 = accountsService.getAccounts(account.getAccountSystemId());



          accounts.setAccounts(accounts1);

          return  accounts;

        }).collect(Collectors.toList());

        customer.setBank(accounts);

        return customer;
    }
}
