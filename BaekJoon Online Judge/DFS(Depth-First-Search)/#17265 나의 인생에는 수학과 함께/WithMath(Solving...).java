/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ17265;

import java.util.ArrayList;
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
    public static int calcExp(ArrayList<Character> exp){
        int index = 0;
        int result = exp.get(index++) -'0';
        //System.out.println("size = " + exp.size());
        
        while(index < exp.size()){
            
            char oper = exp.get(index++);
            int cur = (int)(exp.get(index++) - '0');
            
            //System.out.println("cur = " + cur + " oper = " + oper);
            
            switch (oper) {
                case '+':
                    result += cur;
                    break;
                case '-':
                    result -= cur;
                    break;
                case '*':
                    result *= cur;
                    break;
            }
            //System.out.println("result = " + result);
        }
        
        return result;
    }
    
    public static void calcMinMax(int x, int y, ArrayList<Character> exp){
        exp.add(map[x].charAt(y));

        if(x == N - 1 && y == N - 1){ //끝 지점에 도착하면 Queue에 있는 식을 계산
            int result = calcExp(exp);
            max = Math.max(max, result);
            min = Math.min(min, result);
            exp.remove(exp.size() - 1);
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
        
        exp.remove(exp.size() - 1);
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
        
        calcMinMax(0,0, new ArrayList<>());
        System.out.println(max + " " + min);
    }
    
}
