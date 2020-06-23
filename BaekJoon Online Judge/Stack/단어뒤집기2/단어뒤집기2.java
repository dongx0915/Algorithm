import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void ReverseWord(String str) {
        Stack<Character> stack = new Stack<>();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if(ch == ' '){
                while(!stack.isEmpty()) System.out.print(stack.pop());
                System.out.print(" ");
            }
            else if(ch == '<'){
                while(!stack.isEmpty()) System.out.print(stack.pop());
                while((ch = str.charAt(i++)) != '>'){
                    System.out.print(ch);
                }
                System.out.print(ch);
                i--;
            }
            else stack.push(ch);     
        }
        while(!stack.isEmpty()) System.out.print(stack.pop());
        System.out.println("");
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ReverseWord(str);
    }
}
