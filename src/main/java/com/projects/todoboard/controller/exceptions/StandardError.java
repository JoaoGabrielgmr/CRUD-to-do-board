/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projects.todoboard.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jggmr
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardError implements Serializable{
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-mm-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
