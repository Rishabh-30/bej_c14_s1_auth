//package org.niit.C13_S3_MongoDemo;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.niit.C13_S3_MongoDemo.domain.Address;
//import org.niit.C13_S3_MongoDemo.domain.Customer;
//import org.niit.C13_S3_MongoDemo.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class CustomerRepositoryTest {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    private Address address;
//    private Customer customer;
//
//    @BeforeEach
//    void setUp(){
//        this.address=new Address(440111,"pune");
//        this.customer=new Customer(111112,"Shital","90987654",address);
//    }
//
//    @AfterEach
//    void clear(){
//        this.address=null;
//        this.customer=null;
//    }
//
//    @Test
//    @DisplayName("Test case for saving customer object")
//    void givenCustomerToSaveShouldReturnSavedCustomer(){
//        customerRepository.save(customer);
//        Customer c1=customerRepository.findById(customer.getCustomerId()).get();
//        assertNotNull(c1);
//        assertEquals(customer.getCustomerId(),c1.getCustomerId());
//    }
//
//    @Test
//    @DisplayName("Test case for deleting customer object")
//    public void givenCustomerToDeleteShouldDeleteCustomer(){
//        customerRepository.insert(customer);
//        Customer c1=customerRepository.findById(customer.getCustomerId()).get();
//        customerRepository.delete(c1);
//        assertEquals(Optional.empty(),customerRepository.findById(c1.getCustomerId()));
//
//    }
//
//    @Test
//    @DisplayName("Test case for retrieving all customer object ")
//     public void givenCustomerReturnAllCustomerDetails(){
//        customerRepository.insert(customer);
//        Address address1=new Address(440112,"Nashik");
//        Customer customer1=new Customer(601,"Uday","9098765476",address1);
//        customerRepository.insert(customer1);
//
//       List<Customer> list= customerRepository.findAll();
//       assertEquals(2,list.size());
//       assertEquals("Uday",list.get(1).getCustomerName());
//
//
//     }
//
//
//
//
//}
