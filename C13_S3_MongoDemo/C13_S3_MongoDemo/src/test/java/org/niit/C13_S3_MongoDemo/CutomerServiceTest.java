//package org.niit.C13_S3_MongoDemo;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.niit.C13_S3_MongoDemo.domain.Address;
//import org.niit.C13_S3_MongoDemo.domain.Customer;
//import org.niit.C13_S3_MongoDemo.exception.CustomerAlreadyExistsException;
//import org.niit.C13_S3_MongoDemo.exception.CustomerNotFoundException;
//import org.niit.C13_S3_MongoDemo.repository.CustomerRepository;
//import org.niit.C13_S3_MongoDemo.service.CustomerServiceImp;
//
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class CutomerServiceTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//    @InjectMocks
//    private CustomerServiceImp customerServiceImp;
//
//    private Customer customer;
//    private Address address;
//
//    @BeforeEach
//    void setUp(){
//        this.address=new Address(441100,"mumbai");
//        this.customer=new Customer(10001,"Selena","8909876567",address);
//
//    }
//    @AfterEach
//    void clear(){
//        this.address=null;
//        this.customer=null;
//
//    }
//
//    @Test
//    public void givenCustomerToSaveReturnSavedCustomerSucess() throws CustomerAlreadyExistsException {
//        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
//        when(customerRepository.save(customer)).thenReturn(customer);
//        Assertions.assertEquals(customer,customerServiceImp.addCustomer(customer));
//        verify(customerRepository,times(1)).save(customer);
//        verify(customerRepository,times(1)).findById(any());
//    }
//
//    @Test
//    public void givenCustomerToSaveReturnCustomerFailuer(){
//        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(customer));
//        Assertions.assertThrows(CustomerAlreadyExistsException.class,()->customerServiceImp.addCustomer(customer));
//    }
//
//    @Test
//    public void givenCustomerToDeleteShouldDeleteSuccess() throws CustomerNotFoundException {
//        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(customer));
//        boolean flag=customerServiceImp.deleteCustomer(customer.getCustomerId());
//        Assertions.assertEquals(true,flag);
//
//    }
//
//    @Test
//    public void givenCustomerToDeleteShouldDeleteFailuer(){
//        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
//        Assertions.assertThrows(CustomerNotFoundException.class,()->customerServiceImp.deleteCustomer(customer.getCustomerId()));
//    }
//
//
//
//
//}
