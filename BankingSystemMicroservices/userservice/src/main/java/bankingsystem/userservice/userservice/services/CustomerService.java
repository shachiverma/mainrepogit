package bankingsystem.userservice.userservice.services;

import bankingsystem.userservice.userservice.entities.Customer;

import java.util.List;

public interface CustomerService {

    //create
    Customer saveCustomer(Customer customer);

    //get all customers
    List<Customer> getAllCustomer();

    //get single customer of given customerId;
    Customer getCustomer(String customerId);

    //void deleteCustomer(String customerId);
}
