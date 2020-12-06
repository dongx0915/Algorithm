import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        
        for(int i = 0; i < test; i++){
            StringBuilder num1 = new StringBuilder(scan.next());
            StringBuilder num2 = new StringBuilder(scan.next());
            
            String result = Sum(num1, num2);
        
            System.out.println(result);
        }
    }
    
    public static String Sum(StringBuilder num1, StringBuilder num2){
        StringBuilder result = new StringBuilder();
        int longerLength = (num1.length() > num2.length()) ? num1.length() : num2.length();
        int shorterLength = (num1.length() > num2.length()) ? num2.length() : num1.length();
        int carry = 0;
        
        num1 = num1.reverse();
        num2 = num2.reverse();
        StringBuilder longerStr = (num1.length() > num2.length()) ? num1 : num2;
         
        for(int i = 0;i < longerLength; i++){
            int sum = 0;
            if(i < shorterLength) sum = (num1.charAt(i) - '0') + (num2.charAt(i) - '0');
            else sum = (longerStr.charAt(i) - '0');

            if(i == 0) result.append((sum % 10));
            else{
                result.append(((sum + carry) % 10));
            }

            carry = (sum + carry >= 10) ? 1 : 0;
        }
        
        return result.reverse().toString();
    }
}