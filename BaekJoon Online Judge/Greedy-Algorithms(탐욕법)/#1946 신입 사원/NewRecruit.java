import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Volunteer implements Comparable<Volunteer>{
    int document_;
    int interview_;

    public Volunteer(int document_, int interview_) {
        this.document_ = document_;
        this.interview_ = interview_;
    }
    
    @Override
    public int compareTo(Volunteer v){
        return this.document_ - v.document_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int getPassedPersonnel(PriorityQueue<Volunteer> v){
        int bound = v.poll().interview_;
        int pass = 1;
        
        while(!v.isEmpty()){
            int next = v.poll().interview_;
            if(bound > next){
                pass++;
                bound = Math.min(bound, next);
            }
        }
        
        return pass;
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        while(test-- != 0){
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Volunteer> v = new PriorityQueue<>();
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                v.offer(new Volunteer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            
            System.out.println(getPassedPersonnel(v));
        }
    }
    
}
