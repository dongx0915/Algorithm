/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

/**
 *
 * @author DongHyeon Kim <20183188>
 */
public class 오등큰수 {
    public static String FindMaxToStack(int[] appear, int[] result, int[] sequence, Stack<Integer> stack, int n) {
        int top = 0;
        Arrays.fill(result, -1);        
        stack.push(0);

        for (int i = 1; i < n; i++) {
            
            while (!stack.isEmpty() && (appear[sequence[top = stack.peek()] - 1] < appear[sequence[i] - 1])) {
                result[top] = sequence[i];
                stack.pop();
            }
            stack.push(i);
        }
        
        StringJoiner sj = new StringJoiner(" ");

        for (int r : result)sj.add(r + "");
        
        return sj.toString();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] appear = new int[1000000];
        int[] result = new int[n];
        int[] sequence = new int[n];
        Stack<Integer> stack = new Stack();
        
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
            appear[sequence[i] - 1]++;
        }
        
        System.out.println(FindMaxToStack(appear, result, sequence, stack, n));
 
    }

}
