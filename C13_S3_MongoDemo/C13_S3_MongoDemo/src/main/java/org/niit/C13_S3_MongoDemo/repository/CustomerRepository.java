package org.niit.C13_S3_MongoDemo.repository;

import org.niit.C13_S3_MongoDemo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {

    Customer findByCustomerName(String customerName);

    @Query("{'customerAddress.city' : {$in :[?1]}}")
    List<Customer> fetchCustomerByCity(int zip,String city);
}
