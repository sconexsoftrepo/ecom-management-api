package com.sconexsoft.ecom.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sconexsoft.ecom.entity.EcomUser ;
import com.sconexsoft.ecom.repo.EcomUserRepository;

@Service
public class EcomUserServiceImpl implements EcomUserService {

    @Autowired
    private EcomUserRepository ecomUserRepository;

    // Fetch all users
    @Override
    public List<EcomUser > getAllUsers() {
        return ecomUserRepository.findAll();
    }

    // Fetch a user by ID
    @Override
    public Optional<EcomUser > getUserById(int id) {
        return ecomUserRepository.findById(id);
    }

    // Add a new user
    @Override
    public EcomUser  addUser (EcomUser  user) {
        return ecomUserRepository.save(user);
    }

    // Update an existing user
    @Override
    public EcomUser  updateUser (EcomUser  user) {
        return ecomUserRepository.save(user);
    }

    // Delete a user by ID
    @Override
    public boolean deleteUser (int id) {
        if (ecomUserRepository.existsById(id)) {
            ecomUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}