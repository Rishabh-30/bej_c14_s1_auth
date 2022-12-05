package org.niit.C13_S3_MongoDemo.service;

import org.niit.C13_S3_MongoDemo.domain.Customer;
import org.niit.C13_S3_MongoDemo.exception.CustomerAlreadyExistsException;
import org.niit.C13_S3_MongoDemo.exception.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {

    public Customer addCustomer(Customer c) throws CustomerAlreadyExistsException;
    public List<Customer> getAllCustomer();
    public Customer getCustomerByCustomerName(String customerName);
    public List<Customer> getAllCustomerByCity(String city);
    public boolean deleteCustomer(int id)  throws CustomerNotFoundException;
}
