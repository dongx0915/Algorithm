/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Silver.BOJ2630;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N;
    public static int[][] map;
    public static int blue  = 0;
    public static int white = 0;
    
    public static void check(int x, int y, int scale){
        int first = map[x][y]; // 해당 범위의 첫번째 요소로 초기화
        
        // 종료 조건
        if(scale == 0) return;
        
        for (int i = x; i < x + scale; i++) {
            for (int j = y; j < y + scale; j++) {
                // first와 다르면 더 쪼개져야 한다는 뜻
                // 한 칸이 전부 같은 색이 아닌 경우에만 재귀를 돌려서 중복 방지
                if(map[i][j] != first) {
                    scale /= 2;
                    
                    check(x, y, scale);
                    check(x, (y + scale), scale);
                    check((x + scale), y, scale);
                    check((x + scale), (y + scale), scale);
                    return;
                }
            }
        }
            
        if(first == 0) white++;
        else blue++;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        check(0,0,N);
        
        System.out.println(white);
        System.out.println(blue);
    }
}
