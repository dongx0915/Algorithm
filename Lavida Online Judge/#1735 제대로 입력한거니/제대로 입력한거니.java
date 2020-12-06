import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        
        for(int i = 0; i < test; i++){
            String email = s.next();
    
            if(email.toLowerCase().matches("^[a-zA-Z0-9]{1,15}@ajou.ac.kr$")) System.out.println("Pass");
            else System.out.println("Return");
        }
    }
    
}