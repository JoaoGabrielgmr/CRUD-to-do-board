/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projects.todoboard.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projects.todoboard.domain.Login;
import com.projects.todoboard.repositories.LoginRepository;
import com.projects.todoboard.services.exceptions.ResourceNotFoundException;

/**
 *
 * @author jggmr
 */
@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    
    public List<Login> findAll(){
        return loginRepository.findAll();
    }

    public Login findById(Long id) {
        Optional<Login> obj = loginRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Login insert(Login obj){
        return loginRepository.save(obj);
    }

    public void delete(Long id){
        try{
            loginRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
        }
    }

    public Login update(Long id, Login obj){
        Login entity = loginRepository.getReferenceById(id);
        updateData(entity, obj);
        return loginRepository.save(entity);
    }
    
    private void updateData(Login entity, Login obj){
        entity.setName(obj.getName());
        entity.setPassword(obj.getPassword());
        entity.setBoards(obj.getBoards());
    }
}
