/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projects.todoboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.todoboard.domain.Sticker;


/**
 *
 * @author jggmr
 */
public interface  StickerRepository extends JpaRepository<Sticker, Long>{
}
