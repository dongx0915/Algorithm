import java.io.*;
import java.util.*;

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

    
    public static void bfs(Pair point, char origin_color, char color){
        Queue<Pair> q = new LinkedList<>();
        
        q.add(point);
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
                    
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(cur.x_ + dx[i], cur.y_ + dy[i]);
                if(next.x_ < 0 || next.y_ < 0 || next.x_ >= R || next.y_ >= C) continue;
                char next_char = image[next.x_].charAt(next.y_);
            
                if(next_char == color) continue;
                if(next_char != origin_color) continue;
            
                image[next.x_].setCharAt(next.y_, color);
                q.offer(next);
            }
        }

    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        
        image = new StringBuilder[R];
        
        for (int i = 0; i < R; i++) image[i] = new StringBuilder(br.readLine());
        
        input = br.readLine().split(" ");
        
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        char color = (char)(Integer.parseInt(input[2]) + '0');
        char origin_color = image[x].charAt(y);
        
        image[x].setCharAt(y, color);
        bfs(new Pair(x, y), origin_color, color);
        
        for (StringBuilder str : image) bw.write(str.toString() + "\n");
        bw.flush();
    }
}
