package com.davidh.module1_4;

import java.lang.Math;
public class Circle extends TwoDShape{
    private double radius;

    // Finalized pi value with the math package
    private final double pi = Math.PI;

    // Inherits color from com.davidh.module1_4.TwoDShape but not width and height
    public Circle(int radius, Colour color){
        super(0,0,color);
        this.radius = radius;
    }

    // Getters and Setters
    // Overriding getArea method in com.davidh.module1_4.TwoDShape
    @Override
    public double getArea() {
        return radius * radius * pi;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPi() {
        return pi;
    }

    // Overriding toString method in com.davidh.module1_4.TwoDShape
    @Override
    public String toString() {
        return "Radius: "+radius+" com.davidh.module1_4.Colour: "+getColor();
    }


}