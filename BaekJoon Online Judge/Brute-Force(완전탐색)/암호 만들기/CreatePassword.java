/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 암호 만들기 https://www.acmicpc.net/problem/1759
 * @author DongHyeon Kim <20183188>
 */
public class CreatePassword {

    static char[] alphabet;
    static int pwCnt;
    static int alphaCnt;
    static boolean[] visit;

    // 다 뽑고 최소 자음 두개 && 최소 모음 두개인지 체크
    public static void printPassword(ArrayList<Character> picked) {
        int consonant = 0; // 자음 개수
        int vowel = 0; // 모음 개수
        for (Character ch : picked) {
            if (ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            picked.forEach((ch) -> {
                System.out.print(ch);
            });
            System.out.println();
        }
    }

    public static void makePassword(ArrayList<Character> picked) {
        if (picked.size() == pwCnt) {
            printPassword(picked);
            return;
        }
        
        char lastChar = (char)('a' - 1);
        if(!picked.isEmpty()) lastChar = picked.get(picked.size()-1);
        
        for (int i = 0; i < alphaCnt; i++) {
            if (visit[i] == false && alphabet[i] > lastChar) {
                visit[i] = true;
                picked.add(alphabet[i]);

                makePassword(picked);

                visit[i] = false;
                picked.remove(picked.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> picked = new ArrayList<>();

        pwCnt = sc.nextInt();
        alphaCnt = sc.nextInt();

        alphabet = new char[alphaCnt];
        visit = new boolean[alphaCnt];
 
        for (int i = 0; i < alphaCnt; i++) {
            alphabet[i] = sc.next(".").charAt(0);
        }

        Arrays.sort(alphabet);

        makePassword(picked);
    }

}
