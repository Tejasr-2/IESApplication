package com.ashokit.ies.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.admin.domain.PlansDomain;
import com.ashokit.ies.admin.entity.PlansEntity;
import com.ashokit.ies.admin.repository.PlansRepository;

@Service
public class PlansServiceIMPL implements PlansService {

	@Autowired
	PlansRepository planRepo;

	@Override
	public boolean savePlan(PlansDomain plan) {
		PlansEntity planEntity = new PlansEntity();
		BeanUtils.copyProperties(plan, planEntity);
		planEntity.setPlanStatus("Active");
		PlansEntity saveedEntity = planRepo.save(planEntity);

		return saveedEntity != null;
	}

	@Override
	public List<PlansDomain> getAllPlans() {

		List<PlansEntity> entities = planRepo.findAll();

		List<PlansDomain> plans = new ArrayList<>();

		for (PlansEntity entity : entities) {
			PlansDomain tempDto = new PlansDomain();
			BeanUtils.copyProperties(entity, tempDto);
			plans.add(tempDto);
		}
		return plans;

	}

	@Override
	public PlansDomain findByPlanId(int pid) {
		PlansDomain plan = new PlansDomain();
		Optional<PlansEntity> optional = planRepo.findById(pid);
		PlansEntity plansEntity = optional.get();
		BeanUtils.copyProperties(plansEntity, plan);

		return plan;
	}

	@Override
	public void deactivatePlan(int pid) {

		Optional<PlansEntity> optional = planRepo.findById(pid);
		PlansEntity plansEntity = optional.get();
		plansEntity.setPlanStatus("Deactivated");
		planRepo.save(plansEntity);

	}

	@Override
	public void activatePlan(int pid) {
		Optional<PlansEntity> optional = planRepo.findById(pid);
		PlansEntity plansEntity = optional.get();
		plansEntity.setPlanStatus("Active");
		planRepo.save(plansEntity);

	}

	@Override
	public ArrayList<String> getActivePlans() {
		List<PlansEntity> plansEntity = planRepo.findAll();

		ArrayList<String> activePlans = new ArrayList<>();
		
		for (PlansEntity entity : plansEntity) {
			if(entity.getPlanStatus().equals("Active"))
			{
				activePlans.add(entity.getPlanName());
			}
			
		}
		return activePlans;
	}

}
