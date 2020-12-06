import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        int test = scan.nextInt();
        
        for(int i = 0; i < test; i++){
            String URI = scan.next();
            String[] Special = {"&", "(", ")", "=", "?"};
            String[] Encoded = {"%26", "%28", "%29", "%3d", "%3f"};
            
            for(int j = 0; j < 5; j++){
                URI = URI.replace(Special[j], Encoded[j]);        
            }
            System.out.println(URI);
        }
    }
}
