/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projects.todoboard.domain.enums;

import lombok.Getter;

/**
 *
 * @author jggmr
 */
public enum Color {
    RED(1),
    BLUE(2),
    PINK(3),
    YELLOW(4),
    GREY(5);

    @Getter
    private int code;

    private Color(int code){
        this.code = code;
    }

    public static Color valueOf(int code){
        for(Color value: Color.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }
}
