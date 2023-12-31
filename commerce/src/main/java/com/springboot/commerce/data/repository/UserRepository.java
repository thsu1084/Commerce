package com.springboot.commerce.data.repository;


import com.springboot.commerce.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);

}
