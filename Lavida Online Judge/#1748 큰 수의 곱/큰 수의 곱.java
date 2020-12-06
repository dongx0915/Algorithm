import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);

        int test = scan.nextInt();
        for (int i = 0; i < test; i++) {
            StringBuilder num1 = new StringBuilder(scan.next());
            StringBuilder num2 = new StringBuilder(scan.next());
            
            Multiply(num1, num2);
        }
    }

    public static void Multiply(StringBuilder num1, StringBuilder num2) {
        int LongerLength = (num1.length() > num2.length()) ? num1.length() : num2.length();
        int ShorterLength = (num1.length() > num2.length()) ? num2.length() : num1.length();
        int carry = 0;
        
        StringBuilder ShorterStr = (num1.length() > num2.length()) ? num2.reverse() : num1.reverse();
        StringBuilder LongerStr = (num1.length() > num2.length()) ? num1.reverse() : num2.reverse();
        StringBuilder[] SubResult = new StringBuilder[ShorterLength];
        
        for(int s = 0; s < ShorterLength; s++){
            SubResult[s] = new StringBuilder();
        }
        
        for(int i = 0; i < ShorterLength; i++){
            carry = 0;
            for(int j = 0; j < LongerLength; j++){
                int sum = (ShorterStr.charAt(i) - '0') * (LongerStr.charAt(j) - '0');
                SubResult[i].append((sum + carry) % 10);
                carry = (sum + carry) / 10;
            }
            
            if(carry > 0) SubResult[i].append(carry);
            SubResult[i] = SubResult[i].reverse();
            
            for(int k = 0; k < i; k++) SubResult[i].append(0);
        }
        int length = SubResult.length;
        StringBuilder result = SubResult[0];

        for(int l = 1; l < length; l++){
            result = Sum(result, SubResult[l]);
        }
        System.out.println(result);
    }

    public static StringBuilder Sum(StringBuilder num1, StringBuilder num2) {
        StringBuilder result = new StringBuilder();
        int longerLength = (num1.length() > num2.length()) ? num1.length() : num2.length();
        int shorterLength = (num1.length() > num2.length()) ? num2.length() : num1.length();
        int carry = 0;

        num1 = num1.reverse();
        num2 = num2.reverse();
        StringBuilder longerStr = (num1.length() > num2.length()) ? num1 : num2;

        for (int i = 0; i < longerLength; i++) {
            int sum = 0;
            if (i < shorterLength) {
                sum = (num1.charAt(i) - '0') + (num2.charAt(i) - '0');
            } else {
                sum = (longerStr.charAt(i) - '0');
            }

            if (i == 0) {
                result.append((sum % 10));
            } else {
                result.append(((sum + carry) % 10));
            }
            carry = (sum + carry >= 10) ? 1 : 0;
        }
        
        if(carry > 0) result.append(carry);
        return result.reverse();
    }
}