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
    public static int getClassroom(ArrayList<Lecture> lec_list){
        if(lec_list.isEmpty()) return 0;
        Lecture now_lec = lec_list.get(0);
        lec_list.remove(now_lec);
        
        for (int i = 0; i < lec_list.size();) {
            Lecture next_lec = lec_list.get(i);
            if(now_lec.end_time <= next_lec.start_time){
                lec_list.remove(next_lec);
                now_lec = next_lec;
            }
            else i++;
        }

        return 1 + getClassroom(lec_list);
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lec_list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            lec_list.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        Collections.sort(lec_list);
        
        System.out.println(getClassroom(lec_list));  
    }  
}
