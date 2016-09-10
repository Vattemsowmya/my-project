package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.models.Component;
import com.niit.service.ComponentService;
@Controller
public class ComponentController {

	@Autowired
	 private ComponentService componentService;
	
	@RequestMapping(value="/")
	public String landPage(@ModelAttribute("component")Component component,BindingResult result,Model model)
	{
		
		/*model.addAttribute("allData",componentService.getAllComponents());*/
		return "componentInsert";
		
	}
	 
	@RequestMapping(value="/allData")
	public String getAllData(@ModelAttribute("component")Component component,BindingResult result,Model model)
	{
	
		model.addAttribute("allData",componentService.getAllComponents());
		return"componentInsert";
	}
	@RequestMapping(value="/addComponent",method = RequestMethod.POST)
public String addComponent(@ModelAttribute("component") Component p){
		
		this.componentService.addComponent(p);
			
		
		
		return "redirect:allData";
		
	}
	@RequestMapping(value="/ComponentById/{id}",method = RequestMethod.GET)
	public String editComponent(@PathVariable("id") int id,RedirectAttributes redirectAttributes)
	{
		redirectAttributes.addFlashAttribute("component", componentService.getComponent(id));
		return "redirect:/allData";
		
}
	@RequestMapping(value="/deleteById/{id}",method = RequestMethod.GET)
	public String deleteComponent(@PathVariable("id") int id)
	{
		componentService.deleteComponent(id);
		return "redirect:/allData";
		
}
}


