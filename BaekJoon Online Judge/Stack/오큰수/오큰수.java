import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

public class Main {

    public static String findMaxToStack(Stack<Integer> stack, int[] sequence) {
        int length = sequence.length;
        int top = 0;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        stack.push(0);

        for (int i = 1; i < length; i++) {
            while(!stack.isEmpty()){
                top = stack.peek();
                if(sequence[top] < sequence[i]){
                    result[top] = sequence[i];
                    stack.pop();
                }
                else break;
            }
            stack.push(i);
        }
        
        StringJoiner sj = new StringJoiner(" ");
        for (int num : result) sj.add(num + "");
        return sj.toString();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sequence = new int[n];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i++) sequence[i] = sc.nextInt();
        
        System.out.println(findMaxToStack(stack, sequence));
    }
}
