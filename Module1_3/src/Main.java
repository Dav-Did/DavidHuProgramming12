// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Triangle triangle1 = new Triangle(5,12,13);

        System.out.println(triangle1.getArea());
        System.out.println(triangle1.toString());
        triangle1.setSide1(10.0);
        System.out.println(triangle1.toString());
        System.out.println(triangle1.getArea());
    }
}