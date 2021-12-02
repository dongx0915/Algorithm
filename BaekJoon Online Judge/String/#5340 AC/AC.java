/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String.BOJ5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static String solution(String func, ArrayList<String> list){
        int len = func.length();
        boolean isReverse = false;
        
        for (int i = 0; i < len; i++) {
            char ch = func.charAt(i);
            //리버스 변수를 둬서 false면 앞에서제거 true면 뒤에서 제거
            if(ch == 'R') isReverse = !(isReverse ^ false);
            else if(ch == 'D') {
                if(list.isEmpty()) return "error";
                if(isReverse) list.remove(list.size()-1);
                else list.remove(0);
            }
        }
        
        if(isReverse) Collections.reverse(list);
        
        return list.toString().replaceAll(" ", "");
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here`
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        while(test-- != 0){
            String func = br.readLine();
            int element = Integer.parseInt(br.readLine());
            StringTokenizer sj = new StringTokenizer(br.readLine(), "[\\[\\],]");
            ArrayList<String> list = new ArrayList<>();
            
            while(sj.hasMoreTokens()) list.add(sj.nextToken());
            
            System.out.println(solution(func, list));
        }
    }
    
}
