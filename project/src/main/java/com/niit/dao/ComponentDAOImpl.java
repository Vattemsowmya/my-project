package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.Component;

@Repository("ComponentDAO")
public class ComponentDAOImpl implements ComponentDAO {
	
	
	/*@Override
	public void addComponent(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComponent(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getComponent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComponent(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Component> getAllComponents() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	private SessionFactory sessionFactory;
	
	@Autowired 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addComponent(Component component) {
		 Session session=sessionFactory.getCurrentSession();
		   Transaction trans=session.beginTransaction();
		   session.saveOrUpdate(component);
		   trans.commit();
		}
	
	
	public void updateComponent(Component component) {
		Component componentToUpdate = getComponent(component.getId());
		componentToUpdate.setName(component.getName());
		componentToUpdate.setDescription(component.getDescription());
		componentToUpdate.setPrice(component.getPrice());
		 Session session=sessionFactory.getCurrentSession();
		   Transaction trans=session.beginTransaction();
		   session.saveOrUpdate(component);
		   trans.commit();
	   
    }
		

	public Component getComponent(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		   Transaction trans=session.beginTransaction();
		   Component component=(Component)session.get(Component.class, id);
		   trans.commit();
	        return component;
	}

	public void deleteComponent(int id) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		 Component component = getComponent(id);
	        if (component != null)
	        session.delete(component);
	    
	        trans.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Component> getAllComponents() {
		Session session=sessionFactory.getCurrentSession();
		   Transaction trans=session.beginTransaction();
		 List<Component> list=  session.createQuery("from Component").list();
		   trans.commit();
		   return list;
	}

}
