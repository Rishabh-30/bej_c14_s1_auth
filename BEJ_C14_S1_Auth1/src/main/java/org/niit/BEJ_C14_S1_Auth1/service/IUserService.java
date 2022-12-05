package org.niit.BEJ_C14_S1_Auth1.service;

import org.niit.BEJ_C14_S1_Auth1.domain.User;

import java.util.List;

public interface IUserService {
    public User saveUser(User u);
    public List<User> getAllUsers();
    public User updateUser(User u,String email);
    public String deleteUser(String email);

    public List<User> getAllUserByLastName(String lastname);
    public User loginCheck(String emailId,String password);

}
