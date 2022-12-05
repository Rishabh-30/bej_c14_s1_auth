package org.niit.BEJ_C14_S1_Auth1.controller;

import org.niit.BEJ_C14_S1_Auth1.domain.User;
import org.niit.BEJ_C14_S1_Auth1.service.ISecurityTokenGenerator;
import org.niit.BEJ_C14_S1_Auth1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class UserController {

    public IUserService userService;
    public ISecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public UserController(IUserService userService, ISecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity(userService.getAllUsers(), HttpStatus.OK);
    }

    //http://localhost:8082/api/v1/users  -- POST
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody  User u){
        return new ResponseEntity<>(userService.saveUser(u),HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User result=userService.loginCheck(user.getEmail(),user.getPassword());
        if(result!=null){
            //valid user
            //generate security token
            Map<String,String> map=securityTokenGenerator.tokenGenerator(user);
            return new ResponseEntity<>(map,HttpStatus.OK);

        }else{
            //invalid or not exist
            return new ResponseEntity("invalid user",HttpStatus.NOT_FOUND);


        }
    }

    //http://localhost:8082/api/v1/users/email
    @PutMapping("/users/{email}")
    public ResponseEntity<?> updateUser(@RequestBody User u,@PathVariable String email){
        System.out.println("controller method called");
        return new ResponseEntity<>(userService.updateUser(u,email),HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        return new ResponseEntity<>(userService.deleteUser(email),HttpStatus.OK);
    }

    //http://localhost:8082/api/v1/user/sharma
    @GetMapping("/user/{lastname}")
    public ResponseEntity<?> getAllUserByLastName(@PathVariable String lastname){
        return new ResponseEntity<>(userService.getAllUserByLastName(lastname),HttpStatus.FOUND);
    }
}
