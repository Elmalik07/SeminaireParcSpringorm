package com.cours.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cours.entities.Roles;

public class RolesImpl implements IRoles{
	
private EntityManager em;
	
	public RolesImpl(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SeminaireSrpingorm");
		em = emf.createEntityManager();
		
	}

	@Override
	public Long add(Roles roles) {
		long ok = 0;
		try {
			em.getTransaction().begin();
			em.persist(roles);
			em.getTransaction().commit();
			ok = 1;
		} catch (Exception e) {
			e.printStackTrace();
			ok = 0;
		}
		
		return ok;
	}

	@Override
	public Long update(Roles roles) {
		long ok = 0;
		try {
			em.getTransaction().begin();
			em.merge(roles);
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
			em.remove(em.find(Roles.class, id));
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
	public List<Roles> getAllRoles() {
		
		return em.createQuery("SELECT r FROM Roles r").getResultList();
	}

	@Override
	public Roles get(int id) {
		
		return em.find(Roles.class, id);
	}

}
