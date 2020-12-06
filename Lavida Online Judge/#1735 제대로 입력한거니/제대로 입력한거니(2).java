import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        
        for(int i = 0; i < test; i++){
            String email = s.next();
            StringBuilder str = new StringBuilder(email);
            int length = email.length();
            
            for(int j = 0; j < length; j++){
                char c = email.charAt(j);
                if(c >= 'A' && c <= 'Z') str.setCharAt(j, (char)(c + 32));
            }
            
            email = str.toString();
            if(email.matches("^[a-zA-Z0-9]{1,15}@ajou.ac.kr$")) System.out.println("Pass");
            else System.out.println("Return");
        }
    }
    
}
