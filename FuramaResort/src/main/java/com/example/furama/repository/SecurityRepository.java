package com.example.furama.repository;

import com.example.furama.model.AppRole;
import com.example.furama.model.AppUser;
import com.example.furama.model.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityRepository extends JpaRepository<AppRole,Integer> {

}
