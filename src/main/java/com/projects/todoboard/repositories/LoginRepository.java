/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projects.todoboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.todoboard.domain.Login;

/**
 *
 * @author jggmr
 */
public interface  LoginRepository extends JpaRepository<Login, Long>{
}
