/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ11728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int input(String str){
        return Integer.parseInt(str);
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int aSize = input(st.nextToken());
        int bSize = input(st.nextToken());
        
        int[] a = new int[aSize];
        int[] b = new int[bSize];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) a[i] = input(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) b[i] = input(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        int pa = 0, pb = 0;
        
        while ((pa < aSize) && (pb < bSize)) {
            if(a[pa] <= b[pb]){ if(pa < aSize) sb.append(a[pa++]).append(" ");}
            else if(pb < bSize) sb.append(b[pb++]).append(" ");
        }
        
        while(pa < aSize) sb.append(a[pa++]).append(" ");
        while(pb < bSize) sb.append(b[pb++]).append(" ");
        
        bw.write(sb.toString());
        bw.write("\n");
        bw.flush();
    }
    
}
