/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOJ10250;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int h = sc.nextInt();       //세로
            int w = sc.nextInt();       //가로
            //h층 w개 방
            int n = sc.nextInt();       //n번째 손님
            
            int floor = n % h;
            int room = n / h + 1;
            
            if(floor == 0){
                floor = h;
                room--;
            }
            System.out.println(floor * 100 + room);
        }
    }
    
}
