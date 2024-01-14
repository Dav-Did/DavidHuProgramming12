package com.davidhu.module1_3;

public class Circle extends TwoDShape{
    private double radius;
    private static final double pi = 3.14;

    /**
     * Constructor for circle with radius
     * @param radius The radius of the circle
     */

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * pi;
    } //Calculates the area of the circle with radius and pi

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getPi() {
        return pi;
    }

    @Override
    public String toString() {
        return "Radius: "+radius;
    }
}