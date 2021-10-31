import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static final char ROUND = '(';
    public static final char SQUARE = '[';
    
    public static String isPairString(String str){
        Queue<Character> q = new LinkedList<>();
        int square = 0, round = 0;
        char prev = ' ';
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(round < 0 || square < 0) return "no";
            
            switch (ch) {
                case '(':
                case '[': 
                    q.offer(ch);
                    if(ch == '[') square++; 
                    else round++;
                    break;
                case ')':
                    if(prev != '(' && prev != ' ') return "no";
                    if(!q.isEmpty()) prev = q.poll();
                    
                    if(ch == '[') square--;
                    else round--;
                    break;
                case ']': 
                    if(prev != '[' && prev != ' ') return "no";
                    if(!q.isEmpty()) prev = q.poll();
                    
                    if(ch == '[') square--;
                    else round--;
                    break;
                default : break;
            }
        }
                
        return (round == 0 && square == 0) ? "yes" : "no";
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        
        while(!(str = br.readLine()).equals(".")){
            System.out.println(isPairString(str));
        }
    }
    
}
