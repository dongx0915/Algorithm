package Hash.BOJ2358;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        HashMap<Integer, ArrayList<Integer>> xMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> yMap = new HashMap<>();
        


        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            ArrayList<Integer> xValue = new ArrayList<>();
            ArrayList<Integer> yValue = new ArrayList<>();
            
            if(xMap.containsKey(x)) yValue = xMap.get(x);
            yValue.add(y);
            xMap.put(x, yValue);
            
            if(yMap.containsKey(y)) xValue = yMap.get(y);
            xValue.add(x);
            yMap.put(y, xValue);
        }

        int result = 0;
        for (Integer x : xMap.keySet()) if(xMap.get(x).size() >= 2) result++;
        for (Integer y : yMap.keySet()) if(yMap.get(y).size() >= 2) result++;
        
        System.out.println(result);
    }
}
