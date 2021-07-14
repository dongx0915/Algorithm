/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math.BOJ1676;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static BigInteger fact(BigInteger n){
        if(n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;    //테스트용 팩토리얼 코드
        return n.multiply(fact(n.subtract(BigInteger.ONE)));            //문제에선 구할 필요 없음
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int n = new Scanner(System.in).nextInt();
        System.out.println((n / 5) + (n / 25) + (n / 125));
    }
}
