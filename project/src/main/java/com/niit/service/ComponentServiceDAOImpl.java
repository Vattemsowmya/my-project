package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ComponentDAO;
import com.niit.models.Component;
@Service
public class ComponentServiceDAOImpl implements ComponentService{
	
	
	@Autowired
    private ComponentDAO componentDAO;
	
	
	public boolean addComponent(Component component) {
		componentDAO.addComponent(component);
		return false;

	}
	public void updateComponent(Component component) {
		componentDAO.updateComponent(component);
	}
	
	public Component getComponent(int id) {
		return componentDAO.getComponent(id);
	}
	
	public void deleteComponent(int id) {
		componentDAO.deleteComponent(id);

	}
	
	public List<Component> getAllComponents() {
		return 	componentDAO.getAllComponents();
	}
}
