/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gold.BOJ1717;

/**
 *
 * @author Donghyeon <20183188>
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //parent[x] == x의 부모
    public static int getParent(int x, int[] parent){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent[x], parent);
    }
    
    public static void unionParent(int x, int y, int[] parent){
        x = getParent(x, parent);
        y = getParent(y, parent);
        
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        /*
         * 합집합                         : 0 a b
         * 같은 집합에 포함되어있는지 확인 : 1 a b
         */
        int N = Integer.parseInt(st.nextToken());      //원소(1~n)
        int M = Integer.parseInt(st.nextToken());      //연산의 개수
        int[] parent = new int[N+1];
        
        for (int i = 0; i <= N; i++) parent[i] = i;
        
        int oper, a, b;
        StringBuilder result = new StringBuilder();
        
        //굳이 부모를 찾을 필요 없이 같은 집합인지만 체크
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            oper = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            if(oper == 0) unionParent(a, b, parent);
            else result.append((getParent(a, parent) == getParent(b, parent)) ? "YES" : "NO").append("\n");
        }
        
        System.out.print(result.toString());
    }
}
