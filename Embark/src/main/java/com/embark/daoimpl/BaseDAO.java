package com.embark.daoimpl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.embark.daointerface.IBaseDAO;


@Repository
public class BaseDAO implements IBaseDAO{
	private static final Logger LOGGER =Logger.getLogger(BaseDAO.class);
	
	@Resource(name = "sessionFactory")
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public SessionFactory getFactory() {
		return sessionFactory;
	}
	
	@Transactional
	public void flush(){
		this.getSession().flush();
	}
	@Transactional
	public Object save(Object object) throws Exception  {
		return this.sessionFactory.getCurrentSession().save(object);
	}
	@Transactional
	public void saveOrUpdate(Object object){
		try{
			this.sessionFactory.getCurrentSession().saveOrUpdate(object);
		}catch(Exception e){
			LOGGER.error("Error---> saveOrUpdate---> " + e.getMessage());
		}
	}
	@Transactional
	public void merge(Object object) {
		this.sessionFactory.getCurrentSession().update(object);
	}
	
	@Transactional
	public void delete(Object object){
		this.sessionFactory.getCurrentSession().delete(object);
	}
	@Transactional
	public void persist(Object object) {
		this.sessionFactory.getCurrentSession().persist(object);
	}
}
