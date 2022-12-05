package org.niit.C13_S3_MongoDemo.controller;

import org.niit.C13_S3_MongoDemo.domain.Customer;
import org.niit.C13_S3_MongoDemo.exception.CustomerAlreadyExistsException;
import org.niit.C13_S3_MongoDemo.exception.CustomerNotFoundException;
import org.niit.C13_S3_MongoDemo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    private ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    //http://localhost:8082/api/v1/customers -- post
    @PostMapping("/customers/add")
    public ResponseEntity<?> addCustomer(@RequestBody Customer c) throws CustomerAlreadyExistsException {
        return new ResponseEntity<>(customerService.addCustomer(c), HttpStatus.CREATED);

//        ResponseEntity responseEntity=null;
//        try {
//            responseEntity= new ResponseEntity<>(customerService.addCustomer(c), HttpStatus.CREATED);
//        } catch (CustomerAlreadyExistsException e) {
//            e.printStackTrace();
//        }catch(Exception e){
//            responseEntity= new ResponseEntity("Error ",HttpStatus.SERVICE_UNAVAILABLE);
//        }
//        return responseEntity;
    }

    @GetMapping("/customers/get")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
    @GetMapping("/customer/{customername}")
    public ResponseEntity<?> getCustomerByName(@PathVariable String customername){
        return new ResponseEntity<>(customerService.getCustomerByCustomerName(customername),HttpStatus.FOUND);
    }

    @GetMapping("/allcustomer/{city}")
    public ResponseEntity<?> getCustomerByCity(@PathVariable String city){
        return new ResponseEntity<>(customerService.getAllCustomerByCity(city),HttpStatus.FOUND);
    }
//api/v1/customers/101
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable int id) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
    }

}
