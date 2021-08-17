/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP.BOJ11052;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Card implements Comparable<Card>{
    int pack_;
    double price_;

    public Card(int pack_, double price_) {
        this.pack_ = pack_;
        this.price_ = price_;
    }
    
    //양수일 때 스왑
    @Override
    public int compareTo(Card c){
        return this.price_ > c.price_ ? -1 : 1;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int getMaximumPrice(int n, Card[] card){
        int price = 0;
        
        for (Card c : card) {
            if(c.pack_ > n) continue;
            
            price += (c.price_ * c.pack_) * (n / c.pack_);
            n -= (n / c.pack_) * c.pack_;
                        
            if(n == 0) return price;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Card[] card = new Card[n];
        
        for (int i = 0; i < n; i++) {
            card[i] = new Card(i+1, (double)sc.nextInt() / (i + 1));
        }
        
        Arrays.sort(card);
        for (Card card1 : card) {
            System.out.printf("p[%d] = %f\n", card1.pack_, card1.price_);
        }
        System.out.println(getMaximumPrice(n, card));
    }
    
}
