package bankingsystem.userservice.userservice.controllers;

import bankingsystem.userservice.userservice.entities.Customer;
import bankingsystem.userservice.userservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    //create customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){

       Customer customer1 =  customerService.saveCustomer(customer);
       return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
    }
    //single user get
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getSingleCustomer(@PathVariable String customerId){
    Customer customer = customerService.getCustomer(customerId);
    return ResponseEntity.ok(customer);
    }
    //all user get
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List <Customer> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }
    //update customer
//    @PutMapping("/{customerId}")
//    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId){
//
//    }
    //deleteCustomer
//    @DeleteMapping("/{customerId}")
//    public ResponseEntity.BodyBuilder deleteCustomer(@PathVariable String customerId){
//
//        customerService.deleteCustomer(customerId);
//
//        return ResponseEntity.ok();
//    }
}
