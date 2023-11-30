// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        TwoDShape shape1 = new Triangle(3,4,5, Colour.NONE);
        TwoDShape shape2 = new Circle(5,Colour.RED);

        System.out.println(shape1.toString());
        System.out.println(shape2.toString());


        ((Triangle) shape1).rotate90();
        System.out.println(shape1.toString());
        System.out.println(shape1.getArea());
    }
}