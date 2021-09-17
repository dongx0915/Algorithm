/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ2776;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        
        while(T-- != 0){
            int n = Integer.parseInt(br.readLine());
            HashSet<String> note1 = new HashSet<>();
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) note1.add(st.nextToken());
            
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < m; i++) {
                if(note1.contains(st.nextToken())) sb.append("1\n");
                else sb.append("0\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    
}
