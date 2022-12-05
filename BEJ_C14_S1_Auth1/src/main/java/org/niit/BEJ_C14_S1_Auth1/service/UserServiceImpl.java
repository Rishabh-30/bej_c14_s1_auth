package org.niit.BEJ_C14_S1_Auth1.service;

import org.niit.BEJ_C14_S1_Auth1.domain.User;
import org.niit.BEJ_C14_S1_Auth1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    public UserRepository userRepository;
    @Override
    public User saveUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User u,String email) {//client
        System.out.println("service method called");
        Optional<User> optional=userRepository.findById(email);
        if(optional.isEmpty()){
            return null;
        }
        User result=optional.get();//object from data
        System.out.println("**************************user object*************************"+u);
        System.out.println("**************************result object*************************"+result);
        if(u.getFirstName()!=null ){
            result.setFirstName(u.getFirstName());
        }
        if(u.getPassword()!=null){
            result.setPassword(u.getPassword());
        }
        if(u.getLastName()!=null){
            result.setLastName(u.getLastName());
        }
        return userRepository.save(result);
    }

    @Override
    public String deleteUser(String email) {
        if(userRepository.findById(email).isEmpty()){
            return "User does not exit";
        }
        else{
            userRepository.deleteById(email);
            return "user deleted succefully";
        }
    }

    @Override
    public List<User> getAllUserByLastName(String lastname) {
        return userRepository.findByLastName(lastname);
    }

    @Override
    public User loginCheck(String emailId, String password) {

        if(userRepository.findById(emailId).isPresent()){
            // get userobjet by using emailId
            User user=userRepository.findById(emailId).get();
            //check password
            if(user.getPassword().equals(password)){
                user.setPassword("");
                return user;
            }else{
                //invalid user
                return null;
            }

        }else{
            //user not exits
            return null;
        }
    }
}
