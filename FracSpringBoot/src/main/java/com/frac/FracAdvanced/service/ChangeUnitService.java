package com.frac.FracAdvanced.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.ReservoirFluidModel;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;
import com.frac.FracAdvanced.repository.ReservoirFluidRepo;

@Component
public class ChangeUnitService {
	
	@Autowired
	ProjectDetailRepo repo;
	
	@Autowired
	HttpSession httpSession;
	@Autowired
	ReservoirFluidRepo fluidRepo;
	ProjectDetails p1;
	ProjectDetails pids;
	


	public void convertUnit( String uType)
	{
		pids =(ProjectDetails)httpSession.getAttribute("ProjectDetail");
		   p1=repo.findById(pids.getId()).get();
	      p1.setUnitType(uType);	
	      repo.save(p1);
	      }	
	public void changeUnitOfVTable( String uType)
	{
/*ReservoirFluidModel a1=	fluidRepo.findByParamAndDetails("Initial Reservoir Pressure(psi)", p1).get(0);
a1.setParam("value is changed");
a1.setValue("value is changed");
fluidRepo.save(a1);*/
	//pids	=(ProjectDetails)httpSession.getAttribute("ProjectDetail");
	
		System.out.println(pids.getId());
	
	
	
	}
	
}
