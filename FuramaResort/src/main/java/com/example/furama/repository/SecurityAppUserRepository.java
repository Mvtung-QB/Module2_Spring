package com.example.furama.repository;

import com.example.furama.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityAppUserRepository extends JpaRepository<AppUser,Integer> {

}