/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer.BOJ4158;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int sk, int sy, int[] sk_cd, int[] sy_cd){
        //작은 쪽 인텍스를 증가
        int k = 0, y = 0; //k = 상근 포인터, y = 선영 포인터
        int cnt = 0;
        for (k = 0; k < sk; k++) {
            while(sy_cd[y] < sk_cd[k] && y < sy) y++;
            
            if(sy_cd[y] == sk_cd[k]) cnt++;
        }
        
        return cnt;
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sk = Integer.parseInt(st.nextToken()); //상근이 CD
            int sy = Integer.parseInt(st.nextToken()); //선영이 CD
            if(sk == 0 && sy == 0) break;
            
            int[] sk_cd = new int[sk];
            int[] sy_cd = new int[sy];
            
            for (int i = 0; i < sk; i++) sk_cd[i] = Integer.parseInt(br.readLine());
            for (int i = 0; i < sy; i++) sy_cd[i] = Integer.parseInt(br.readLine());
            
            
            sb.append(solution(sk, sy, sk_cd, sy_cd)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
