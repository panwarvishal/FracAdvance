/**
 * 
 */
package com.frac.FracAdvanced.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.ReservoirFluidModel;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;
import com.frac.FracAdvanced.repository.ReservoirFluidRepo;

@Service
public class ReservoirFluidService {

	@Autowired
	ReservoirFluidRepo fluidRepo;
	@Autowired
	ProjectDetailRepo detailRepo;
	@Autowired
	HttpSession httpSession;

	public java.util.List<ReservoirFluidModel> getListMethod(int pid, String ftype, String radioValue)
			throws Exception {
		ArrayList<ReservoirFluidModel> a1 = new ArrayList<ReservoirFluidModel>();

		java.util.List<ReservoirFluidModel> x12 = fluidRepo.findByFluidtypeAndDetails(ftype, detailRepo.getOne(pid));
		return x12;		
	}

	public java.util.List<ReservoirFluidModel> methodEditValue(int pid, String ftype, java.util.List<String> value)
			throws Exception {		
		java.util.List<ReservoirFluidModel> x12 = fluidRepo.findByFluidtypeAndDetails(ftype, detailRepo.getOne(pid));
		for (int i = 0; i < x12.size(); i++) {
			x12.get(i).setValue(value.get(i));
			fluidRepo.save(x12.get(i));
		}
		java.util.List<ReservoirFluidModel> x123 = fluidRepo.findByFluidtypeAndDetails(ftype, detailRepo.getOne(pid));
		return x123;
	}

	public void methodEditWellTypeSelected(int pid, String wellTypeSelected, String ftype) throws Exception {

		ProjectDetails p1 = detailRepo.getOne(pid);
		List<ReservoirFluidModel> all = fluidRepo.findBydetails(p1);
		for (int i = 0; i < all.size(); i++) {
			all.get(i).setWellTypeSelected(wellTypeSelected);
			fluidRepo.save(all.get(i));
		}
	}
	
	public ArrayList<String> RfParamList(String rf3Type, int pid) throws Exception
	{ArrayList<String> aList=null;
	

	String uTypeDataBase= detailRepo.findById(pid).get().getUnitType();
	
	if(uTypeDataBase.equalsIgnoreCase("Field"))
	
	{	if(rf3Type.equalsIgnoreCase("Reservoir properties"))
		{
		String [] a= {"(psi)","(psi)"," (psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)"};
		aList = new ArrayList<String>(Arrays.asList(a));}
		else if(rf3Type.equalsIgnoreCase("Fracture Mechanics Properties"))
		{	String [] a= {"(psi)","(psi)"," (psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)"};
		 aList = new ArrayList<String>(Arrays.asList(a));}
		else if(rf3Type.equalsIgnoreCase("Optimum Fracture Design Input"))
		{	String [] a= {"(psi)","(psi)"," (psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)","(psi)"};
		 aList = new ArrayList<String>(Arrays.asList(a));}
	}	
	
	else if (uTypeDataBase.equalsIgnoreCase("Metric"))
	{if(rf3Type.equalsIgnoreCase("Reservoir properties"))
	{
	String [] a= {"(metric)","(matric)"," (F)"," (%)"," (md)","matric","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)"};
	aList = new ArrayList<String>(Arrays.asList(a));}
	else if(rf3Type.equalsIgnoreCase("Fracture Mechanics Properties"))
	{	String [] a= {"(metric)","(matric)"," (F)"," (%)"," (md)","matric","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)"};
	 aList = new ArrayList<String>(Arrays.asList(a));}
	else if(rf3Type.equalsIgnoreCase("Optimum Fracture Design Input"))
	{	String [] a= {"(metric)","(matric)"," (F)"," (%)"," (md)","matric","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)","(metric)"};
	 aList = new ArrayList<String>(Arrays.asList(a));}
}
		
	
	return aList;
	}
	
}
