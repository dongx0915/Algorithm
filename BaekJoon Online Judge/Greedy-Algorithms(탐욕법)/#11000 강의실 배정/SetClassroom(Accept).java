import java.io.*;
import java.util.*;
class Lecture implements Comparable<Lecture>{
    int start_time;
    int end_time;
    
    public Lecture(int start_time, int end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    @Override
    public int compareTo(Lecture o) {
        if(this.start_time == o.start_time) return this.end_time - o.end_time;
        return this.start_time - o.start_time;
    }
}

public class Main {
    public static int getClassroom_q(Lecture[] lecture, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lecture[0].end_time);
        
        for (int i = 1; i < n; i++) {
            if(pq.peek() <= lecture[i].start_time) pq.poll();
            pq.add(lecture[i].end_time);
        }
        return pq.size();
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Lecture[] lecture = new Lecture[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            lecture[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(lecture);
        
        System.out.println(getClassroom_q(lecture, n));
    }
}
