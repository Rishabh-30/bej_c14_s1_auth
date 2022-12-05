package org.niit.BEJ_C14_S1_Auth1.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.niit.BEJ_C14_S1_Auth1.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements ISecurityTokenGenerator{
    @Override
    public Map<String, String> tokenGenerator(User user) {
        String jwtToken=null;

        jwtToken= Jwts.builder()
                .setSubject(user.getFirstName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"securityKey")
                .compact();

        Map<String,String> map=new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","User successfully loggedin");
        return map;
    }

    @SpringBootApplication
    public static class BejC14S1Auth1Application {

        public static void main(String[] args) {
            SpringApplication.run(BejC14S1Auth1Application.class, args);
        }

    }
}
