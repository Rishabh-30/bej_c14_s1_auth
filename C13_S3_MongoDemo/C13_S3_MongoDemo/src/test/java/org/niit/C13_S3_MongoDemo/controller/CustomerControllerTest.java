//package org.niit.C13_S3_MongoDemo.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.niit.C13_S3_MongoDemo.controller.CustomerController;
//import org.niit.C13_S3_MongoDemo.domain.Address;
//import org.niit.C13_S3_MongoDemo.domain.Customer;
//import org.niit.C13_S3_MongoDemo.exception.CustomerAlreadyExistsException;
//import org.niit.C13_S3_MongoDemo.exception.CustomerNotFoundException;
//import org.niit.C13_S3_MongoDemo.service.CustomerServiceImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class CustomerControllerTest {
//
//    @Mock
//    private CustomerServiceImp customerService;
//    @InjectMocks
//    private CustomerController customerController;
//    @Autowired
//    private MockMvc mockMvc;
//
//    Address address;
//    Customer customer;
//
//    @BeforeEach
//    void setUp() {
//        this.address = new Address(4000441, "Bhopal");
//        this.customer = new Customer(1901, "Isha", "908765432", address);
//        //specify which controller
//        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
//    }
//
//    @AfterEach
//    void clear() {
//        this.address = null;
//        this.customer = null;
//    }
//
//    @Test
//    public void givenCustomerToSaveReturnSavedCustomer() throws Exception {
//        when(customerService.addCustomer(any())).thenReturn(customer);
//        mockMvc.perform(post("/api/v1/customers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(convertJsonToString(customer))).
//                andExpect(status().isCreated()).
//                andDo(MockMvcResultHandlers.print());
//
//    }
//
//    @Test
//    public void givenCustomerToSaveReturnSavedCustomerFailuer() throws Exception{
//        when(customerService.addCustomer(any())).thenThrow(CustomerAlreadyExistsException.class);
//        mockMvc.perform(post("/api/v1/customers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(convertJsonToString(customer))
//                ).andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void givenCustomerIdDeleteCustomer() throws Exception {
//        when(customerService.deleteCustomer(anyInt())).thenReturn(true);
//        mockMvc.perform(delete("/api/v1/customers/1901").
//                contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenCustomerIdDeleteCustomerFailuer() throws Exception {
//        when(customerService.deleteCustomer(anyInt())).thenThrow(CustomerNotFoundException.class);
//        mockMvc.perform(delete("/api/v1/customers/1901").
//                        contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    private static String convertJsonToString(final Object ob) {
//        String result;
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String jsonContent = mapper.writeValueAsString(ob);
//            result = jsonContent;
//        } catch (JsonProcessingException e) {
//            result = "Json parser error";
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
