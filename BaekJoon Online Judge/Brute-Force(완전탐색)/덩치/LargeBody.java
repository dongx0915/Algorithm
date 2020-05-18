/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.Scanner;

/**
 *
 * @author DongHyeon Kim <20183188>
 */
class Person {

    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

}

public class LargeBody {

    public static int[] rank(Person[] ps, int n) {
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((ps[i].height < ps[j].height) && (ps[i].weight < ps[j].weight)) {
                    rank[i]++;
                }
            }
        }

        return rank;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] ps = new Person[n];

        for (int i = 0; i < n; i++) ps[i] = new Person(sc.nextInt(), sc.nextInt());

        int[] rank = rank(ps, n);

        for (int s : rank) System.out.println(s+1);
    }
}
