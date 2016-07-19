package com.embark.daointerface;

import java.math.BigDecimal;
/*
 *
 * */
 public interface IBaseDAO {
    public void flush();	
	public Object save(Object object) throws Exception ;	
	public void merge(Object object);
	public void delete(Object object);	
	public void saveOrUpdate(Object object);	
	public void persist(Object object);	
}
