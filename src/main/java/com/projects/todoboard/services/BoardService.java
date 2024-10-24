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

import com.projects.todoboard.domain.Board;
import com.projects.todoboard.repositories.BoardRepository;
import com.projects.todoboard.services.exceptions.ResourceNotFoundException;

/**
 *
 * @author jggmr
 */
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public Board findById(Long id) {
        Optional<Board> obj = boardRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Board insert(Board obj){
        return boardRepository.save(obj);
    }

    public void delete(Long id){
        try{
            boardRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
        }
    }

    public Board update(Long id, Board obj){
        Board entity = boardRepository.getReferenceById(id);
        updateData(entity, obj);
        return boardRepository.save(entity);
    }
    
    private void updateData(Board entity, Board obj){
        entity.setName(obj.getName());
        entity.setStickers(obj.getStickers());
    }
}
