import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());   //포켓몬의 개수
        int M = Integer.parseInt(st.nextToken());   //문제의 개수
        HashMap<String, Integer> map = new HashMap<>();
        String[] poket = new String[N + 1];
        
        String name;
        for (int i = 1; i <= N; i++) {
            name = br.readLine();
            map.put(name, i);
            poket[i] = name;
        }
        
        String ques;
        for (int i = 0; i < M; i++) {
            ques = br.readLine();
            if(ques.matches("^\\d+$")) result.append(poket[Integer.parseInt(ques)]).append("\n");
            else result.append(map.get(ques)).append("\n");
        }
        System.out.print(result);
    }
}
