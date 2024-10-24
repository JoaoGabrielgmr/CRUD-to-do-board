/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projects.todoboard.domain;

import java.io.Serializable;

import com.projects.todoboard.domain.enums.Color;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author jggmr
 */

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "tb_sticker")
public class Sticker implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sticker;

    @EqualsAndHashCode.Exclude
    private String title;
    
    @EqualsAndHashCode.Exclude
    private Color color;

    @EqualsAndHashCode.Exclude
    private String content;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Board board = new Board();
}
