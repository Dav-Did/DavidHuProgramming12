package com.davidhu.module1_3;

public abstract class TwoDShape {
    private double width;
    private double height;

    /**
     * Constructor for twoDshapes with width and height
     * @param width The width of the shape
     * @param height
     */

    public TwoDShape(double width, double height){
        this.width = width;
        this.height = height;
    }

    public TwoDShape(){

    }

    public abstract double getArea(); //Get area method overridden in triangle and circle

    public void setHeight(double newHeight){

        this.height = newHeight;
    }

    public double getHeight(){

        return height;
    }

    public void setWidth(double newWidth){

        this.width = newWidth;
    }

    public double getWidth(){

        return width;
    }

    public String toString() {
        String strWidth = Double.toString(width);
        String strHeight = Double.toString(height);
        return "Width: " + strWidth + " Height: " + strHeight;
    }

    public double getNumber(){
        return 1.0;
    }

    
}
