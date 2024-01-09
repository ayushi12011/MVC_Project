package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.model.model;

@Repository
@Component
public class UserDao {
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void insertUser(model m) {
		this.hibernateTemplate.saveOrUpdate(m);
	}
	@Transactional
	public void deleteUser(model m) {
		this.hibernateTemplate.delete(m);
	}
	
	public model getUserById(int id) {
		model  u = this.hibernateTemplate.get(model.class, id);
		return u;
	}
	
	public List<model> getAllUser(){
		List<model> list = this.hibernateTemplate.loadAll(model.class);
		return list;
	}
}
