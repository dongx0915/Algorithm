package Hash.BOJ2358;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xPos = new int[n];
        int[] yPos = new int[n];
        
        for (int i = 0; i < n; i++) {
            xPos[i] = sc.nextInt();
            yPos[i] = sc.nextInt();
        }
        
        Arrays.sort(xPos);
        Arrays.sort(yPos);
        
        boolean xLine = false, yLine = false;
        int result = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if(xPos[i] == xPos[i + 1]) xLine = true;
            else if(xLine) {
                result++;
                xLine = false;
            }
            if(yPos[i] == yPos[i + 1]) yLine = true;
            else if(yLine){
                result++;
                yLine = false;
            }
        }
        
        if(xLine) result++;
        if(yLine) result++;
        
        System.out.println(result);
    }
}
