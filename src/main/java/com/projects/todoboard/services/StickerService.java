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

import com.projects.todoboard.domain.Sticker;
import com.projects.todoboard.repositories.StickerRepository;
import com.projects.todoboard.services.exceptions.ResourceNotFoundException;

/**
 *
 * @author jggmr
 */
@Service
public class StickerService {

    @Autowired
    private StickerRepository stickerRepository;

    
    public List<Sticker> findAll(){
        return stickerRepository.findAll();
    }

    public Sticker findById(Long id) {
        Optional<Sticker> obj = stickerRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Sticker insert(Sticker obj){
        return stickerRepository.save(obj);
    }

    public void delete(Long id){
        try{
            stickerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
           throw new ResourceNotFoundException(id);
        }
    }

    public Sticker update(Long id, Sticker obj){
        Sticker entity = stickerRepository.getReferenceById(id);
        updateData(entity, obj);
        return stickerRepository.save(entity);
    }
    
    private void updateData(Sticker entity, Sticker obj){
        entity.setTitle(obj.getTitle());
        entity.setColor(obj.getColor());
        entity.setContent(obj.getContent());
    }
}
