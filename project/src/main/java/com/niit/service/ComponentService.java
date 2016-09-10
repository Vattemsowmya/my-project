package com.niit.service;

import java.util.List;

import com.niit.models.Component;

public interface ComponentService {


	  public boolean addComponent(Component component);
	    public void updateComponent(Component component);
	    public Component getComponent(int id);
	    public void deleteComponent(int id);
	    public List<Component> getAllComponents();
	
}
