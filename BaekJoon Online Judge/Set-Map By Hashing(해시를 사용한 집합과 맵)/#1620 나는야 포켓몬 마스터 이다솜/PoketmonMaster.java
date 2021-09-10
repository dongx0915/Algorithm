/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());   //포켓몬의 개수
        int M = Integer.parseInt(st.nextToken());   //문제의 개수
        HashMap<Integer, String> mapI = new HashMap<>();
        HashMap<String, Integer> mapS = new HashMap<>();
        
        String name;
        for (int i = 1; i <= N; i++) {
            name = br.readLine();
            mapI.put(i, name);
            mapS.put(name, i);
        }
        
        String ques;
        for (int i = 0; i < M; i++) {
            ques = br.readLine();
            if(ques.matches("^\\d+$")) System.out.println(mapI.get(Integer.parseInt(ques)));
            else System.out.println(mapS.get(ques));
        }
    }
    
}
