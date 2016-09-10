package com.niit.dao;

import java.util.List;

import com.niit.models.Component;

public interface ComponentDAO {
	  public void addComponent(Component component);
	    public void updateComponent(Component component);
	    public Component getComponent(int id);
	    public void deleteComponent(int id);
	    public List<Component> getAllComponents();
	 
}
