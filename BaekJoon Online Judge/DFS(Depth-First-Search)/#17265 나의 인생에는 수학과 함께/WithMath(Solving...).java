/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ17265;

import java.util.Queue;
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
    public static String[] map;
    public static boolean[][] visited;
    public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static boolean isWithinRange(int x, int y){
        return !(x < 0 || y < 0 || x >= N || y >= N);
    }
    public static int caclExp(Queue<Character> exp){
        int result = exp.poll();
        char oper = ' ';
        
        while(exp.isEmpty()){
            char cur = exp.poll();
            
            if('1' <= cur && cur <= '9'){ //cur이 숫자인 경우
                switch(oper){
                    case '+' :
                        result += cur + '0';
                        break;
                    case '-' :
                        result -= cur + '0';
                        break;
                    case '*' :
                        result *= cur + '0';
                        break;
                }
            }   
            else{                         //연산자인 경우
                oper = cur;
            }
        }
        
        return result;
    }
    public static void calcMinMax(int x, int y, Queue<Character> exp){
        exp.offer(map[x].charAt(y));
        
        if(x == N - 1 && y == N - 1){ //끝 지점에 도착하면 Queue에 있는 식을 계산
            
            return;
        }
        
        int[][] next = {{x + 1, y}, {x, y + 1}};
        
        for (int i = 0; i < 2; i++) {
            int nextX = next[i][0];
            int nextY = next[i][1];
            if(!isWithinRange(nextX, nextY) || visited[nextX][nextY]) continue;
            
            visited[nextX][nextY] = true;
            
            calcMinMax(nextX, nextY, exp);
            
            visited[nextX][nextY] = false;
        }
        
        exp.poll();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new String[N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            map[i] = sc.useDelimiter("\n").next().replaceAll(" ", "");
        }
        
    }
    
}
