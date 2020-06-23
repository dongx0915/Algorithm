import java.util.*;
import java.io.*;

public class Main {

    static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    static Stack<Character> left = new Stack<>();
    static Stack<Character> right = new Stack<>();
    
    public static void executeCommand(String command){
        
        switch (command) {
            case "L":
                if(!left.isEmpty())right.push(left.pop());
                break;
            case "D":
                if(!right.isEmpty()) left.push(right.pop());
                break;
            case "B":
                if(!left.isEmpty()) left.pop();
                break;
            default:
                left.push(command.charAt(2));
                break;
        }
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        StringBuilder result = new StringBuilder();
        String str = sc.next();
        int n = sc.nextInt();
            
        for (int i = 0; i < str.length(); i++) left.push(str.charAt(i));

        while (n-- != 0) executeCommand(sc.next());
        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) result.append(right.pop());
        System.out.println(result);
    }
}
