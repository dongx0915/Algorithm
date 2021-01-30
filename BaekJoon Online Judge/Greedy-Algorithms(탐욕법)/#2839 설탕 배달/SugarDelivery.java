/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sugar;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Sugar {

    /**
     * @param args the command line arguments
     */
    public static int getMinimumBag(int n){
        int result = 0;
        int origin_n = n;
        if(n % 5 == 0) return n / 5;
        
        result += n / 5;
        n %= 5;
     
        while(n <= origin_n){
            if(n % 3 == 0)return result + (n / 3);
            else{
                result--;
                n += 5;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.println(getMinimumBag(n));
    }
    
}
