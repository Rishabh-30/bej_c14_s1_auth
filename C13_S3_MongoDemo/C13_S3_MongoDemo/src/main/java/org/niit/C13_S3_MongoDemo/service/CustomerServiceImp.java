package org.niit.C13_S3_MongoDemo.service;

import org.niit.C13_S3_MongoDemo.domain.Customer;
import org.niit.C13_S3_MongoDemo.exception.CustomerAlreadyExistsException;
import org.niit.C13_S3_MongoDemo.exception.CustomerNotFoundException;
import org.niit.C13_S3_MongoDemo.repository.CustomerRepository;
import org.niit.C13_S3_MongoDemo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer c) throws CustomerAlreadyExistsException {
        //return customerRepository.insert(c); or
        if(customerRepository.findById(c.getCustomerId()).isPresent()){
            throw new CustomerAlreadyExistsException();
        }
        return customerRepository.save(c);

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByCustomerName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }

    @Override
    public List<Customer> getAllCustomerByCity(String city) {
        return customerRepository.fetchCustomerByCity(100,city);
    }

    @Override
    public boolean deleteCustomer(int id) throws CustomerNotFoundException {

        if(customerRepository.findById(id).isEmpty()){
            throw new CustomerNotFoundException();
        }
        customerRepository.deleteById(id);
        return true;
    }
}
