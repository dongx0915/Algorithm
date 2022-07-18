/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Gold.BOJ10830;

import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int[][] multiplyMatrix(int[][] matrixA, int[][] matrixB) {
        int size = matrixA.length;
        int[][] result = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j]; // 여기서 % 1000을 적용하면 안됨
                }
                result[i][j] %= 1000;
            }
        }
        
        return result;
    }
    
    public static int[][] squareMatrix(int[][] matrix, long square){
        if(square == 1) return matrix;
        
        int[][] temp = squareMatrix(matrix, square / 2);
        temp = multiplyMatrix(temp, temp);

        if(square % 2 == 1) return temp = multiplyMatrix(temp, matrix);
        else return temp;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        long square = sc.nextLong();
        
        int[][] input = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // square가 1인 경우에도 1000으로 나눈 나머지를 출력 해야하므로
                // 입력 받으면서 바로 1000으로 나눈 나머지를 
                input[i][j] = sc.nextInt() % 1000;
            }
        }
        
        for (int[] is : squareMatrix(input, square)) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

}
