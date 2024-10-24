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

import com.projects.todoboard.domain.Board;
import com.projects.todoboard.services.BoardService;

/**
 *
 * @author jggmr
 */

@RestController
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping
    public ResponseEntity<List<Board>> findAll(){
        List<Board> list = service.findAll();
        return ResponseEntity.ok().body(list);  
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Board> findById(@PathVariable Long id) {
        Board obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Board> insert(@RequestBody Board obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_board()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Board> update(@PathVariable Long id, @RequestBody Board obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
    
}
