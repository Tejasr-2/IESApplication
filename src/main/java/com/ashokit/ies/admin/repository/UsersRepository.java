package com.ashokit.ies.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.admin.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Serializable>{

	public List<UsersEntity> findAllByRole(String role);

	public UsersEntity findByEmail(String email);
}
