/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projects.todoboard.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projects.todoboard.domain.Login;
import com.projects.todoboard.services.LoginService;

/**
 *
 * @author jggmr
 */

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping
    public ResponseEntity<List<Login>> findAll(){
        List<Login> list = service.findAll();
        return ResponseEntity.ok().body(list);  
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Login> findById(@PathVariable Long id) {
        Login obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Login> insert(@RequestBody Login obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_login()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Login> update(@PathVariable Long id, @RequestBody Login obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
    
}
