package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;

import com.sconexsoft.ecom.entity.EcomUser ;

public interface EcomUserService {
	
	public List<EcomUser> getAllUsers();
	public Optional<EcomUser> getUserById(int id);
	public EcomUser  addUser (EcomUser  user);
	public EcomUser  updateUser (EcomUser  user);
	public boolean deleteUser (int id);
}