package org.jsp.userappspring.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.userappspring.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao 
{
  @Autowired	
  private EntityManager manager;
  
  
  public EntityManager getManager() {
	return manager;
}


  public void setManager(EntityManager manager) {
	this.manager = manager;
}


  public User saveUser(User u)
  {
	  EntityTransaction t=manager.getTransaction();
	  manager.persist(u);
	  t.begin();
	  t.commit();
	  return u;
  }
  
  public User updateUser(User u)
  {
	  EntityTransaction t=manager.getTransaction();
	  manager.merge(u);
	  t.begin();
	  t.commit();
	  return u;
  }
  
  public User findById(int id)
  {
	  return manager.find(User.class,id);
  }
  
  public boolean deleteUser(int id)
  {
	  User u=findById(id);
	  if(u!=null)
	  {
		  manager.remove(u);
		  EntityTransaction t=manager.getTransaction();
		  t.begin();
		  t.commit();
		  return true;
	  }
	  return false;
  }
  
  public User verifyUser(long phone,String password)
  {
	  String jpql="select u from User u where u.phone=?1 and u.password=?2";
	  Query q=manager.createQuery(jpql);
	  q.setParameter(1, phone);
	  q.setParameter(2, password);
	  try {
	  return (User)q.getSingleResult();
	  }
	  catch(NoResultException e)
	  {
		  return null;
	  }
  }
  
  public User verifyUser(String email,String password)
  {
	  String jpql="select u from User u where u.email=?1 and u.password=?2";
	  Query q=manager.createQuery(jpql);
	  q.setParameter(1, email);
	  q.setParameter(2, password);
	  try {
	  return (User)q.getSingleResult();
	  }
	  catch(NoResultException e)
	  {
		  return null;
	  }
  }
  
  public User verifyUser(int id,String password)
  {
	  String jpql="select u from User u where u.id=?1 and u.password=?2";
	  Query q=manager.createQuery(jpql);
	  q.setParameter(1, id);
	  q.setParameter(2, password);
	  try {
	  return (User)q.getSingleResult();
	  }
	  catch(NoResultException e)
	  {
		  return null;
	  }
  }
}
