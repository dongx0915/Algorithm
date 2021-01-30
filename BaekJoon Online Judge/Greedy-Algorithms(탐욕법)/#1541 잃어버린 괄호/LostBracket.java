/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baekjoon.LostBracket;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int getMinResult(String[] num, String[] operate){
        int result = Integer.parseInt(num[0]);
        int temp = 0;
        boolean minus_turn = false;
        
        for (int i = 1; i < operate.length; i++) {
            minus_turn = operate[i].equals("-") ^ minus_turn;       //xor 연산
            
            if(minus_turn) temp += Integer.parseInt(num[i]);        // - > +, + > - 인 경우엔 그냥 temp에 더해두기
            else{                                                   // + > +, - > - 인 경우
                if(temp != 0){                                      // 기존의 temp를 result에 부호를 반전시켜 더해주기    
                    temp += Integer.parseInt(num[i]);
                    result -= temp;
                    temp = 0;
                }
                else temp += Integer.parseInt(num[i]);
                
                if(operate[i].equals("-")) minus_turn = true;       // - > -인 경우 minus_turn을 true로 고쳐주기
                else {                                              // + > +인 경우는 그냥 result에 더하기    
                    result += Integer.parseInt(num[i]);             // 위에서 temp != 0이면 temp에 num[i]를 더해주는데
                    temp = 0;                                       // temp는 -가 나온 경우에만 사용되는 변수이다. 따라서 +가 나왔으면 temp를 초기화해준다.
                }            
            }
        }
        
        if(temp != 0) result -= temp;                                //반복문이 끝나고 temp가 남아있으면 result에서 빼주기
            
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] num = input.split("\\+|-");
        String[] oper = input.split("\\d{1,}");
        
        System.out.println(getMinResult(num, oper));
        
    }
}
