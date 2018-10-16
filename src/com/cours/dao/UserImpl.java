package com.cours.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cours.entities.User;

public class UserImpl implements IUser{
	
private EntityManager em;
	
	public UserImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeminaireSrpingorm");
		em = emf.createEntityManager();
		
	}
	@Override
	public Long add(User user) {
		long ok = 0;
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		
		return ok;
	}

	@Override
	public Long update(User user) {
		long ok = 0;
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		
		return ok;
	}

	@Override
	public Long delete(int id) {
		long ok = 0;
		try {
			em.getTransaction().begin();
			em.remove(em.find(User.class, id));
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		
		return ok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	public User get(int id) {
		
		return em.find(User.class, id);
	}

}
