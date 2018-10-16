package com.cours.dao;

import java.util.List;

import com.cours.entities.User;

public interface IUser {
	public Long add(User user);
	public Long update(User user);
	public Long delete(int id);
	public List<User> getAllUsers();
	public User get(int id);

}
