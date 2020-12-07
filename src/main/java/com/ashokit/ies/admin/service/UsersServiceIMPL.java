package com.ashokit.ies.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.admin.domain.UsersDomain;
import com.ashokit.ies.admin.entity.UsersEntity;
import com.ashokit.ies.admin.repository.UsersRepository;

@Service
public class UsersServiceIMPL implements UsersService {

	@Autowired
	private UsersRepository userRepo;

	@Override
	public boolean saveUser(UsersDomain user) {

		UsersEntity userEntity = new UsersEntity();
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setAccStatus("Active");
		UsersEntity save = userRepo.save(userEntity);
		return save != null;
	}

	@Override
	public List<UsersDomain> getAllUsersByRole(String role) {

		List<UsersEntity> entities = userRepo.findAllByRole(role);

		List<UsersDomain> users = new ArrayList<>();

		for (UsersEntity entity : entities) {
			UsersDomain tempDto = new UsersDomain();
			BeanUtils.copyProperties(entity, tempDto);
			users.add(tempDto);
		}
		return users;

	}

	@Override
	public String isUniqueEmail(String email) {

		UsersEntity userEntity = userRepo.findByEmail(email);
		return (userEntity != null) ? "DUPLICATE" : "UNIQUE";
	}

	@Override
	public UsersDomain findByUid(int uid) {
		UsersDomain user = new UsersDomain();
		Optional<UsersEntity> findById = userRepo.findById(uid);
		UsersEntity usersEntity = findById.get();
		BeanUtils.copyProperties(usersEntity, user);
		
		return user;
	}

	@Override
	public List<UsersDomain> getAllUsers() {


		List<UsersEntity> entities = userRepo.findAll();

		List<UsersDomain> users = new ArrayList<>();

		for (UsersEntity entity : entities) {
			UsersDomain tempDto = new UsersDomain();
			BeanUtils.copyProperties(entity, tempDto);
			users.add(tempDto);
		}
		return users;
		
	}

	@Override
	public void deactivateUser(int uid) {
		Optional<UsersEntity> optional = userRepo.findById(uid);
		UsersEntity entity = optional.get();
		entity.setAccStatus("Deactivated");
		userRepo.save(entity);
		
		
	}

	@Override
	public void activateUser(int uid) {
		Optional<UsersEntity> optional = userRepo.findById(uid);
		UsersEntity entity = optional.get();
		entity.setAccStatus("Active");
		userRepo.save(entity);
	}


}
