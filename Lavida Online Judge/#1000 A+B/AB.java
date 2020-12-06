import java.io.IOException;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Scanner sc = new Scanner(System.in);
            
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            System.out.println(a + b);
            
        } catch (Exception e) {

        }
    }

}
