import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static ArrayList<Character> oper = new ArrayList<>();
    
    public static boolean isSequence(int n, ArrayList<Integer> num){
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; !num.isEmpty(); ) {
            int current = stack.isEmpty() ? 0 : (int)stack.peek();
           // System.out.println(i);
            if(stack.isEmpty() && num.get(0) < i) return false;
            if(num.get(0) == current){
                oper.add('-');
                stack.pop();
                num.remove(0);
            }
            else if(num.get(0) >= i){
                stack.push(i++);
                oper.add('+');
            }
            else if(num.get(0) < i){
                stack.pop();
                oper.add('-');
            }
        }
        return num.isEmpty();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);        
        ArrayList<Integer> num = new ArrayList<>();
        
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            num.add(sc.nextInt());
        }
        
        if(!isSequence(n, num)) System.out.println("NO");
        else {
            oper.forEach((c) -> {
                System.out.println(c);
            });
        }   
    }
}
