import java.io.*;
import java.util.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        String name, status;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            status = st.nextToken();
            
            if("enter".equals(status)) set.add(name);
            else if(set.contains(name)) set.remove(name);
        }
        
        Object[] member = set.toArray();
        Arrays.sort(member, Collections.reverseOrder());
        
        for (Object s : member) {
            System.out.println(s);
        }
    }
}
