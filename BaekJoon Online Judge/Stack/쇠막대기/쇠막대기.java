import java.util.*;

public class Main { //* 레이저 입장에서 자르는 막대기 수를 계산하기 * 
    public static void cuttingIronBar(String str){
        Stack<Integer> stack = new Stack<>();
        int length = str.length();
        int piece = 0;
        
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            
            if(ch == '(') stack.push(i);
            else if (ch == ')'){
                if(stack.pop() + 1 == i) piece += stack.size();
                else piece++;
            }
        }
        System.out.println(piece);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        cuttingIronBar(str);
    }
}
