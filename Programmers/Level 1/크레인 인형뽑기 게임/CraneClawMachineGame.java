/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craneclawmachinegame;

import java.util.Stack;

/**
 *
 * @author Donghyeon <20183188>
 */
public class CraneClawMachineGame {

    /**
     * @param args the command line arguments
     */
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> picked = new Stack<>();
        int answer = 0;
        int col = board.length;
        
        for (int move : moves) {
            int lastPick = 0;
            for (int i = 0; i < col; i++) {
                if(board[i][move-1] != 0){
                    if(!picked.isEmpty()) lastPick = picked.peek();
                    if(lastPick == board[i][move-1]){
                        answer++;
                        picked.pop();
                    }
                    else picked.push(board[i][move -1]);
                    board[i][move-1] = 0;
                    
                    break;
                }
            }
        }
        
        return answer * 2;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //같은 숫자는 같은 캐릭터를 나타냄
        // (0,3) - 1
        // (4,1) - 5
        // (moves - 1, max)
        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}
        };
        
        int[] moves = {1,5,3,5,1,2,1,4};
        
        System.out.println(solution(board, moves));
    }

}
