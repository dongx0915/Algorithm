/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomato;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static int[][] randomBox(int width, int height) {
        int[][] box = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                box[i][j] = (int) (Math.random() * 2);
            }
        }
            
        return box;
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int testcase = 1;
        int test= 10;
        
//        int[][] box = {
//            {1, -1, 0, 0, 0, 0},
//            {0, -1, 0, 0, 0, 0},
//            {0, 0, 0, 0, -1, 0},
//            {0, 0, 0, 0, -1, 1},
//        };
                
        while (true) {
            int width = (int) (Math.random() * 5) + 2;
            int height = (int) (Math.random() * 5) + 2;
            int[][] box = randomBox(width, height);
            
            int answer = AnswerTomato.start(width, height, copy(box));
            int my = Tomato.start(width, height, copy(box));

            
            if (answer != my) {
                System.out.println("Answer = " + answer + " My = " + my);
                System.out.println(width + " " + height);
                printBox(copy(box));
                break;
            }
            else{
                System.out.println("testcase " + testcase++ + " 통과");
            }
            System.out.println("");
        }
    }

    public static int[][] copy(int[][] box){
        int[][] copy = new int[box.length][box[0].length];
        
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                copy[i][j] = box[i][j];
            }
        }
        return copy;
    }
    public static void printBox(int[][] box) {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                System.out.printf("%2d ", box[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
