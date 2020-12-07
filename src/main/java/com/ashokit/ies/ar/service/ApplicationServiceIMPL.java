package com.ashokit.ies.ar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.entity.ApplicationEntity;
import com.ashokit.ies.ar.repository.ApplicationRepository;

@Service
public class ApplicationServiceIMPL implements ApplicationService {

	@Autowired
	ApplicationRepository applicationRepo;

	@Override
	public String saveApplication(Application application) {
		ApplicationEntity entity = new ApplicationEntity();
		BeanUtils.copyProperties(application, entity);
		entity.setApplicationStatus("Active");
		ApplicationEntity savedEntity = applicationRepo.save(entity);

		return savedEntity.getApplicationId();
	}

	@Override
	public String chekcState(Application application) {

		return null;
	}

	@Override
	public List<Application> getAllApplications() {

		List<ApplicationEntity> allApplications = applicationRepo.findAll();
		List<Application> applications = new ArrayList<Application>();
		
		
		for (ApplicationEntity entity : allApplications) {
			Application tmpDto = new Application();
			BeanUtils.copyProperties(entity, tmpDto);
			applications.add(tmpDto);
		}

		return applications;
	}

	@Override
	public Application getApplicationById(String aid) {
		
		Application application = new Application();
		Optional<ApplicationEntity> optional = applicationRepo.findById(aid);
		ApplicationEntity applicationEntity = optional.get();
		BeanUtils.copyProperties(applicationEntity, application);
		
		return application;
	}

	@Override
	public void deactivateApplication(String aid) {
		Optional<ApplicationEntity> optional = applicationRepo.findById(aid);
		ApplicationEntity applicationEntity = optional.get();
		applicationEntity.setApplicationStatus("Deactivated");
		applicationRepo.save(applicationEntity);
		
	}

	@Override
	public void activateApplication(String aid) {
		Optional<ApplicationEntity> optional = applicationRepo.findById(aid);
		ApplicationEntity applicationEntity = optional.get();
		applicationEntity.setApplicationStatus("Active");
		applicationRepo.save(applicationEntity);
	}

}
