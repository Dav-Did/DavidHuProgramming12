import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("X value:");
        Integer x = Integer.valueOf(input.nextLine());

        System.out.println("Y value:" );
        Integer y = Integer.valueOf(input.nextLine());

        if (x > 0) {
            if (y > 0){
                System.out.println("Quadrant 1");
            }
            else {
                System.out.println("Quadrant 4");
            }
        }
        else {
            if (y > 0){
                System.out.println("Quadrant 2");
            }
            else {
                System.out.println("Quadrant 3");
            }
        }

    }


}
