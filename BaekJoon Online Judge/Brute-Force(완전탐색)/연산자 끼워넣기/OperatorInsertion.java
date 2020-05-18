/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DongHyeon Kim <20183188>
 */
public class OperatorInsertion {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] opers;
    static int[] num;
    
    public static char[] initOperator(int operCnt){
        char[] operators = new char[operCnt];
        char[] init = {'+', '-', '*', '/'};
        int index = 0;
        for(int i = 0; i < 4; i++){
            
            for(int j = 0; j < opers[i]; j++){
                operators[index++] = init[i]; 
            }
        }
        
        return operators;
    }
    
    public static int getResult(ArrayList<Integer> picked, char[] operators){
        int size = picked.size();
        int result = num[0];
        
        for (int i = 0; i < size; i++) {
            char op = operators[picked.get(i)];
            
            switch(op){
                case '+': 
                    result += num[i + 1];
                    break;                
                case '-': 
                    result -= num[i + 1];
                    break;
                case '*': 
                    result *= num[i + 1];
                    break;
                case '/': 
                    result /= num[i + 1];
                    break;
            }
        }
        return result;
    }
    public static void PickOperator(char[] operators, int operCnt, boolean[] visit, ArrayList<Integer> picked) {
        if (picked.size() == operCnt) {
            int result = getResult(picked, operators);
            
            max = Integer.max(max, result);
            min = Integer.min(min, result);
        }

        for (int i = 0; i < operCnt; i++) {
            if (!visit[i]) {
                picked.add(i);
                visit[i] = true;

                PickOperator(operators, operCnt, visit, picked);

                picked.remove(picked.size() - 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int numCnt = sc.nextInt();
        num = new int[numCnt];
        ArrayList<Integer> picked = new ArrayList<>();

        for (int i = 0; i < numCnt; i++) num[i] = sc.nextInt();
        
        int operCnt = 0;
        opers = new int[4];

        for (int i = 0; i < 4; i++) {
            opers[i] = sc.nextInt();
            operCnt += opers[i];
        }
        
        boolean[] visit = new boolean[operCnt];    
        char[] operators = initOperator(operCnt);

        PickOperator(operators, operCnt, visit, picked);
        System.out.println(max);
        System.out.println(min);

    }

}
