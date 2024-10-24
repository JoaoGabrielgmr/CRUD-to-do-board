/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projects.todoboard.services.exceptions;

/**
 *
 * @author jggmr
 */
public class ResourceNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. id " + id);
    }
}
