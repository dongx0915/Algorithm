/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Picnic;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author MSI
 */
class Friends {

    int first;
    int second;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public Friends(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void FriendCheck(int[][] friendMatrix, Friends[] friend) {
        int length = friend.length;
        int col = friendMatrix.length;
        int row = friendMatrix[0].length;

        for (int i = 0; i < col; i++) {
            friendMatrix[i][i] = -1;
        }
        for (int i = 0; i < length; i++) {
            friendMatrix[friend[i].getFirst()][friend[i].getSecond()] = 1;
        }
    }

    public static void printMatrix(int[][] friendMatrix) {
        int col = friendMatrix.length;
        int row = friendMatrix[0].length;
        
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                System.out.printf("%4d", friendMatrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void make(int student_cnt){
        int[] num = new int[student_cnt];
        for(int i = 0; i < student_cnt; i++){
            num[i] = i;
        }
          
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- != 0) {
            int student_cnt = sc.nextInt();
            int friend_cnt = sc.nextInt();
            Friends[] friend = new Friends[friend_cnt];
            int[][] friendMatrix = new int[student_cnt][student_cnt];

            for (int i = 0; i < friend_cnt; i++) {
                friend[i] = new Friends(sc.nextInt(), sc.nextInt());
            }
            
            FriendCheck(friendMatrix, friend);
            printMatrix(friendMatrix);
        }
        
        
    }

}
