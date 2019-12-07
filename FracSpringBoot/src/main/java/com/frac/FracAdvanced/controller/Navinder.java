package com.frac.FracAdvanced.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.frac.FracAdvanced.model.ProjectDetails;
import org.springframework.beans.factory.annotation.Autowired;
import com.frac.FracAdvanced.repository.MiniFracRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;
import com.frac.FracAdvanced.service.ReportParamService;

/**
 * @author ShubhamGaur
 *
 */
@Controller
@SessionAttributes(value = {"ProjectDetail"})
public class Navinder {
	
	@Autowired
	MiniFracRepo service;
	@Autowired
	ReportParamService reportparamservice; 
	@Autowired
	ProjectDetailRepo prodetails;
	
	@RequestMapping("/list")
	public String show(@ModelAttribute("ProjectDetail") ProjectDetails details,HttpSession session,Model model){
		session.setAttribute("ProjectDetail", details);
		session.setAttribute("PDId", details.getId());

		model.addAttribute("doneSim", reportparamservice.simulationDone(details.getId()));
		session.setAttribute("unitType", prodetails.findById(details.getId()).get().getUnitType());
		return "projectDetails/projectDetail";
	}
	
	@RequestMapping("/showgraphs")
	public String graphView(@ModelAttribute("ProjectDetail") ProjectDetails details,HttpSession session) {
		session.setAttribute("ProjectDetail", details);
		return "view/showgraph";
	}
	
		
	
	
}
