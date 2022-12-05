package org.niit.BEJ_C14_S1_Auth1.repository;

import org.niit.BEJ_C14_S1_Auth1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

    public List<User> findByLastName(String lastname);
}
