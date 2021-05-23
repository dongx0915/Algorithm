/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOJ;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Card {
    int num_;
    int cnt_;

    public Card(int num_) {
        this.num_ = num_;
        this.cnt_ = 0;
    }
        
    @Override
    public boolean equals(Object o){
        if(o instanceof Card) return this.hashCode() == ((Card)o).hashCode();
        else return false;
    }

    @Override
    public int hashCode() {
        return this.num_;
    }
}

public class Main {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //카드 개수
        Set<Card> card = new HashSet<>();
        Iterator<Card> iter;
        int[] number = new int[n];
        
        for (int i = 0; i < n; i++) card.add(new Card((number[i] = sc.nextInt())));
        for (int i = 0; i < n; i++) {
            Card input = new Card(number[i]);
            if(card.contains(input)){
                iter = card.iterator();
                while(iter.hasNext()){
                    Card target = iter.next();
                    if(target.equals(input)) target.cnt_++;
                }
            }
        }
        
        int k = sc.nextInt();
        StringJoiner result = new StringJoiner(" ");
        
        for (int i = 0; i < k; i++) {
            Card target = new Card(sc.nextInt());
            iter = card.iterator();
            
            if(card.contains(target)){
                while(iter.hasNext()){
                    Card c = iter.next();
                    if(c.num_ == target.num_) {
                        result.add(c.cnt_ + "");
                        break;
                    }
                }
            }
            else result.add("0");
        }
        System.out.println(result.toString());
    }
}
