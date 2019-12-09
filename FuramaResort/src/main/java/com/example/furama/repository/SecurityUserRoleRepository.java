package com.example.furama.repository;

import com.example.furama.model.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityUserRoleRepository extends JpaRepository<RoleUser,Integer> {

}