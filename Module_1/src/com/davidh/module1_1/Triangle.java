package com.davidh.module1_1;

import java.lang.Math;
public class Triangle extends TwoDShape{
    private double side1;
    private double side2;
    private double side3;

    /**
     * Constructor for triangle with width and height
     * @param width Width of triangle
     * @param height Height of triangle
     */

    public Triangle(double width, double height) {
        super(width, height);
    }

    /**
     * Constructor for triangle with three sides
     * @param side1 First side of triangle
     * @param side2 Second side of triangle
     * @param side3 Third side of triangle
     */

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setWidth(side1);
        setHeight(heronsHeight());
    }


    /**
     * Calculates height and area using Heron's Formula
     * See https://en.wikipedia.org/wiki/Heron%27s_formula
     * @return the area and the height of the triangle
     */

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); //Calculates the area using Heron's Formula
    }

    private double heronsHeight() {
        double area = getArea();
        double base = side1; //Set side1 as the base arbitrarily
        return (2 * area) / base;  //Calculates the height from the area earlier
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return "Side 1: "+side1+" Side 2: "+side2+" Side 3: "+side3;
    }
}
