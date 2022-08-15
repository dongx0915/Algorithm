/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Silver.BOJ1074;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int r, c;

    public static int zSearch(int x, int y, int size){
        int start = 0;
        
        while (size > 1) {
            size /= 2;
            int area = (size * size);
            
            if (x + size <= r && y + size <= c) { // 우하단
                start += 3 * area;
                x += size;
                y += size;
            } else if (x + size <= r && y <= c) { // 좌하단
                start += 2 * area;
                x += size;
            } else if (x <= r && y + size <= c) { // 우상단
                start += area;
                y += size;
            }
        }
        
        return start;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        
        System.out.println(zSearch(0, 0, (int)Math.pow(2, N)));
    }
}
