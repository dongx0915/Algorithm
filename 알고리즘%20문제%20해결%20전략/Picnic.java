/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Picnic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
class Friends {

    int[] pair;

    Friends() {
        this.pair = new int[2];
        this.pair[0] = 0;
        this.pair[1] = 0;
    }

    public Friends(int first, int second) {
        this.pair = new int[2];
        this.pair[0] = first;
        this.pair[1] = second;
    }
}

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static int Factorial(int n) {
        int multiple = 1;
        for (int i = n; i > 0; i--) {
            multiple *= i;
        }

        return multiple;
    }

    public static int Permutation(int n, int r) {
        return Factorial(n) / Factorial(n - r);
    }

    public static int Combination(int n, int r) {
        return Permutation(n, r) / Factorial(r);
    }

    public static void printMatrix(int[][] friendMatrix) {
        int col = friendMatrix.length;
        int row = friendMatrix[0].length;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.printf("%4d", friendMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void FriendCheck(int[][] friendMatrix, Friends[] friend) {
        int length = friend.length;
        int col = friendMatrix.length;
        int row = friendMatrix[0].length;

        for (int i = 0; i < col; i++) {
            friendMatrix[i][i] = -1;
        }
        for (int i = 0; i < length; i++) {
            friendMatrix[friend[i].pair[0]][friend[i].pair[1]] = 1;
        }
    }

    public static int allCase(int student_cnt) {
        int multi = 1;
        for (int i = student_cnt; i >= 2; i -= 2) {
            multi *= Combination(i, 2);
        }

        return multi / Factorial(student_cnt / 2);
    }

    public static int PairFrequency(int student_cnt) {
        int multi = 1;
        for (int i = student_cnt - 2; i >= 2; i -= 2) {
            multi *= Combination(i, 2);
        }
        return multi / Factorial((student_cnt - 2) / 2);
    
    }

    public static boolean overlapCheck(int[] Pair, Friends[] FreindPair, int PairMax) {
        for (int i = 0; i < PairMax; i++) {
            for (int j = 0; j < 2; j++) {
                if (FreindPair[i].pair[0] == Pair[0] || FreindPair[i].pair[1] == Pair[1]) {
                    return false;
                }
                if (FreindPair[i].pair[0] == Pair[1] || FreindPair[i].pair[1] == Pair[0]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void getUniquePair(int[][] PairCheck, Friends[] FriendPair, int PairMax, int use_cnt) {
        int student_cnt = PairCheck.length;

        for (int k = 1; k < student_cnt; k++) {
            for (int i = 1; i < student_cnt; i++) {
                for (int j = i + 1; j < student_cnt; j++) {
                    if (PairCheck[i][j] < use_cnt) {
                        int[] Pair = {i, j};

                        if (overlapCheck(Pair, FriendPair, PairMax)) {
                            PairCheck[i][j]++;
                            PairCheck[j][i]++;
                            FriendPair[k].pair[0] = i;
                            FriendPair[k].pair[1] = j;
                            i = j = student_cnt;
                        }
                    }
                }
            }
            //printMatrix(PairCheck);
            //System.out.println();
        }
    }
    
    public static int[][] copy(int[][] PairCheck){
       int[][] copyArray = new int[PairCheck.length][PairCheck[0].length];
        
        for(int i = 0; i < PairCheck.length; i++){
            for(int j = 0; j < PairCheck[0].length; j++){
                copyArray[i][j] = PairCheck[i][j];
            }
        }
        return copyArray;
    }
    
    public static void MadeOrderedPair(int allCase, int student_cnt) {
        Friends[][] FriendPair = new Friends[allCase][student_cnt / 2]; // need initialize

        for (int i = 0; i < allCase; i++) {
            FriendPair[i] = new Friends[student_cnt / 2];
            for (int j = 0; j < student_cnt / 2; j++) {
                FriendPair[i][j] = new Friends();
            }
        }

        int PairMax = PairFrequency(student_cnt);
        System.out.println("max = " + PairMax);
        int[][] PairCheck = new int[student_cnt][student_cnt];
        int init = 1;

        for (int i = 1; i <= allCase; i++) {
            FriendPair[i - 1][0] = new Friends(0, init);
            if (i % PairMax == 0) {
                PairCheck[0][init] = PairMax;
                init++;
            }
        }

        int index = 0;
        int[][] copyArray = copy(PairCheck);
   
        for (int i = 0; i < allCase; i++) {
            if(i % PairMax == 0) copyArray = copy(PairCheck);
            getUniquePair(copyArray, FriendPair[i], PairMax, index + 1);
            
        }

        for (int i = 0; i < allCase; i++) {
            for (int j = 0; j < student_cnt / 2; j++) {
                System.out.printf("(%d, %d)\t", FriendPair[i][j].pair[0], FriendPair[i][j].pair[1]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- != 0) {
            int student_cnt = sc.nextInt();
            int friend_cnt = sc.nextInt();

            Friends[] friend = new Friends[friend_cnt]; // Freind Pari Count 
            int[][] friendMatrix = new int[student_cnt][student_cnt];

            for (int i = 0; i < friend_cnt; i++) {
                friend[i] = new Friends(sc.nextInt(), sc.nextInt());
            }

            //FriendCheck(friendMatrix, friend);
            //printMatrix(friendMatrix);
            System.out.println("all = " + allCase(student_cnt));
            MadeOrderedPair(allCase(student_cnt), student_cnt);
        }
       // MadeOrderedPair(15, 6);
    }

}
