import java.io.*;
import java.util.*;

public class Main {
    public static HashMap<Long, Long> sequence;
    
    public static long getSequence(long index, long P, long Q){
        if(sequence.containsKey(index)) return sequence.get(index);
        
        long pi = getSequence(index / P, P, Q);
        long qi = getSequence(index / Q, P, Q);
        sequence.put(index, pi + qi);
        
        return sequence.get(index);
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        //A[0] = 1
        //A[i] = A[i/P] + a[i/Q] (i >= 1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());
        
        sequence = new HashMap<>();
        sequence.put((long)0, (long)1);
        
        bw.write(getSequence(N, P, Q) + "\n");
        bw.flush();
    }
}
