package org.niit.BEJ_C14_S1_Auth1.service;

import org.niit.BEJ_C14_S1_Auth1.domain.User;

import java.util.Map;

public interface ISecurityTokenGenerator {
    public Map<String,String> tokenGenerator(User user);
}
