import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        File text = new File(happyorsad.txt);
        Scanner textScan = new Scanner(text);
        String stringScan = textScan.nextLine();

        int smileFace = StringUtils.countMatchs(stringScan,":-)");
        int sadFace = StringUtils.countMatchs(stringScan,":-()");
        
        if (smileFace > sadFace){
            System.out.println("happy")
        }
        else if (sadFace > smileFace){
            System.out.println("sad")
        }
        else if (sadFace == 0 && smileFace == 0){
            System.out.println("none")
        }
        else {
            System.out.println("unsure")
        }
    }
 

}
