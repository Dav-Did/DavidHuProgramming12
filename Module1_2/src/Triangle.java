import java.lang.Math;
public class Triangle extends TwoDShape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double width, double height){
        super(width, height);
    }

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        setWidth(side1);
        setHeight(heronsHeight());

    }

    public double getArea() {

        double area = getWidth() * getHeight() / 2;
        return area;
    }

    public double heronsHeight() {
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
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
        setHeight(side1);
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
