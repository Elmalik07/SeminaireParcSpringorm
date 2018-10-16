package com.cours.dao;

import java.util.List;

import com.cours.entities.Profil;
import com.cours.entities.User;

public interface IProfil {
	
	public Long add(Profil profil);
	public Long update(Profil profil);
	public Long delete(int id);
	public List<Profil> getAllProfils();
	public Profil get(int id);
	public List<User> getUsersByProfil(int idProfil);
		
	

}
