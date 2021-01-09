/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Complex {

    /**
     * @param args the command line arguments
     */
    public static int n;
    public static int[][] map;
    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};
    public static ArrayList<Integer> eachComp;
    
    public static int numbering(int idx1, int idx2){
        int cnt = 0;
        map[idx1][idx2] = 0;
        
        for (int i = 0; i < 4; i++) {
            int nextX = idx1 + dx[i];
            int nextY = idx2 + dy[i];
            
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
            if(map[nextX][nextY] == 1) {
                cnt += numbering(nextX, nextY);
            }
        }
        
        return cnt + 1;
    }
    
    public static int getComplexCnt(){
        int complexCnt = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    eachComp.add(numbering(i,j));
                    complexCnt++;
                }
            }
        }
        return complexCnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        eachComp = new ArrayList<>();
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
       
        System.out.println(getComplexCnt());
        Collections.sort(eachComp);
        
        eachComp.forEach(integer -> {
            System.out.println(integer);
        });
    }
}
