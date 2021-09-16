package Hash.BOJ2358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, ArrayList<Integer>> xMap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> yMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
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
