package com.example.juegoCarros.domain.helpers;

public enum Colors {
    BLUE("Blue"),
    RED("Red"),
    GREEN("Green"),
    WHITE("White"),
    BLACK("Black"),
    PINK("Pink"),
    YELLOW("Yellow"),
    ORANGE("Orange"),
    BROWN("Brown"),
    VIOLET("Violet");

    private String color;

    Colors(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
