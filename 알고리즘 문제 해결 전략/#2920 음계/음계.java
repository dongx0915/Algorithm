import java.util.Scanner;

public class Main {
    public static String isMelody(int[] num){
        int prev = num[0];
        boolean ascending = true;
        boolean descending = true;
        
        for (int i = 1; i < 8; i++) {
            if(prev < num[i]) descending = false;
            if(prev > num[i]) ascending = false;
            prev = num[i];
        }
        
        if(ascending == descending) return "mixed";
        if(ascending) return "ascending";
        else return "descending";
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int[] num = new int[8];
        
        for (int i = 0; i < 8; i++) num[i] = sc.nextInt();
        System.out.println(isMelody(num));
    }
}