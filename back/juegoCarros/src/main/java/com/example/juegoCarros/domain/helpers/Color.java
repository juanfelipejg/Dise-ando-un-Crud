package com.example.juegoCarros.domain.helpers;

public enum Color {
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

    Color(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
