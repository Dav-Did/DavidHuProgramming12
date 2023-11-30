import java.lang.Math;
public class Circle extends TwoDShape{
    private double radius;
    private double pi;
    public Circle(int radius){
        this.radius = radius;
        this.pi = 3.14;
        final double pi;
    }

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

    @Override
    public String toString() {
        return "Radius: "+radius;
    }
}