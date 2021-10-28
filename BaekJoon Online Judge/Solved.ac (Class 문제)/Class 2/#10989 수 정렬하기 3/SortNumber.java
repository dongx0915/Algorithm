import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(num);
        
        
        for (int i : num) {
            bw.write(String.valueOf(i));
            bw.write("\n");
        }
        
        bw.flush();
    }
}
