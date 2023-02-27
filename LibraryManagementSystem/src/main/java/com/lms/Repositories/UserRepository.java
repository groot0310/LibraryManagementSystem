package com.lms.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
