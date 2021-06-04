
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS.BOJ15240;

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
class Pair{
    int x_, y_;

    public Pair(int x_, int y_) {
        this.x_ = x_;
        this.y_ = y_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int R,C;
    public static StringBuilder[] image;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = { 0,-1, 0, 1};
    
    public static void dfs(int x, int y, char origin_color, char color){
        if(x < 0 || y < 0 || x >= R || y >= C || image[x].charAt(y) != origin_color) return;
        image[x].setCharAt(y, color);
        
        dfs(x + 1, y, origin_color, color);
        dfs(x - 1, y, origin_color, color);
        dfs(x, y + 1, origin_color, color);
        dfs(x, y - 1, origin_color, color);
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        image = new StringBuilder[R];
        
        for (int i = 0; i < R; i++) image[i] = new StringBuilder(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char color = (char)(Integer.parseInt(st.nextToken()) + '0');
        char origin_color = image[x].charAt(y);
        
        dfs(x,y, origin_color, color);
        
        StringBuilder sb = new StringBuilder();
        
        for (StringBuilder str : image){
            sb.append(str);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
}
