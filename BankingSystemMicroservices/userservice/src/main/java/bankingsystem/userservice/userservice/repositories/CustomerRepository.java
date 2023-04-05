package bankingsystem.userservice.userservice.repositories;

import bankingsystem.userservice.userservice.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {


}
