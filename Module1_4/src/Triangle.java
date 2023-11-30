import java.lang.Math;
public class Triangle extends TwoDShape implements Rotate{
    private double side1;
    private double side2;
    private double side3;
    private Colour color;

    private double angle = 0.0;

    // Constructor that inherits the variables from TwoDShape
    public Triangle(double width, double height,Colour color){
        super(width, height,color);
    }

    // Constructor with side 1, side 2, side 3, and color fields.
    public Triangle(double side1, double side2, double side3, Colour color){
        super(0,0,color);

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Return the area using the heron formula.
    public double getArea() {
        return heronsHeight();
    }

    // Calculates the area using the side1, side2, side3, and the heron formula.
    private double heronsHeight() {
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    // Getters and setters
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

        // Sets the height as side1 arbitrarily
        setHeight(side1);
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }


    // Overrides toString method in TwoDShape
    @Override
    public String toString() {
        return "Side 1: "+side1+" Side 2: "+side2+" Side 3: "+side3+" Angle: "+angle+" Colour: "+getColor();
    }

    // Rotate interface overriding
    @Override
    public void rotate90() {
        angle = angle + 90.0;
    }

    @Override
    public void rotate180() {
        angle = angle + 180.0;
    }

    @Override
    public void rotate(double angle) {
        this.angle = this.angle + angle;
    }
}
