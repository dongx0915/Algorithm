/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBoardCover;

import java.util.Scanner;

/**
 *
 * @author MSI
 */
class Point {

    int x;
    int y;
}

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- != 0) {
            int height = sc.nextInt();
            int width = sc.nextInt();

            StringBuilder[] Board = new StringBuilder[height];

            for (int i = 0; i < height; i++) {
                Board[i] = new StringBuilder(sc.next());
            }

            System.out.println(CoverBoard(Board, 0));
        }
    }

    public static int printBoard(StringBuilder[] Board) {
        int fillCnt = 0;
        int height = Board.length;
        int width = Board[0].length();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Board[i].charAt(j) == '#') {
                    fillCnt++;
                }
                System.out.print(Board[i].charAt(j));
            }
            System.out.println();
        }
        System.out.println();
        
        return fillCnt;
    }

    public static int CoverBoard(StringBuilder[] Board, int start_i) {
        int[] x_point = {1, 0, -1, 0, -1, 0, 0, 1};
        int[] y_point = {0, 1, 0, 1, 0, -1, -1, 0};
        int height = Board.length;
        int width = Board[0].length();

        int fillCnt = 0;
            
        if (printBoard(Board) == (height * width)) {
            return 1;
        }

        int ret = 0;
        for (int i = start_i; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Board[i].charAt(j) != '#') {
                    char x, y, z;

                    if ((i + 1) < height && (j + 1) < width) {
                        x = Board[i].charAt(j);
                        y = Board[i + 1].charAt(j);
                        z = Board[i].charAt(j + 1);

                        if (x == '.' && y == '.' && z == '.') {
                            Board[i].setCharAt(j, '#');
                            Board[i + 1].setCharAt(j, '#');
                            Board[i].setCharAt(j + 1, '#');
                            ret += CoverBoard(Board, i); // need ret

                            Board[i].setCharAt(j, '.');
                            Board[i + 1].setCharAt(j, '.');
                            Board[i].setCharAt(j + 1, '.');

                        }
                    } // end if

                    if ((i - 1) >= 0 && (j + 1) < width) {
                        x = Board[i].charAt(j);
                        y = Board[i - 1].charAt(j);
                        z = Board[i].charAt(j + 1);

                        if (x == '.' && y == '.' && z == '.') {
                            Board[i].setCharAt(j, '#');
                            Board[i - 1].setCharAt(j, '#');
                            Board[i].setCharAt(j + 1, '#');
                            ret += CoverBoard(Board, i);

                            Board[i].setCharAt(j, '.');
                            Board[i - 1].setCharAt(j, '.');
                            Board[i].setCharAt(j + 1, '.');
                        }
                    } // end if
                    if ((i - 1) >= 0 && (j - 1) >= 0) {
                        x = Board[i].charAt(j);
                        y = Board[i - 1].charAt(j);
                        z = Board[i].charAt(j - 1);

                        if (x == '.' && y == '.' && z == '.') {
                            Board[i].setCharAt(j, '#');
                            Board[i - 1].setCharAt(j, '#');
                            Board[i].setCharAt(j - 1, '#');
                            ret += CoverBoard(Board, i);

                            Board[i].setCharAt(j, '.');
                            Board[i - 1].setCharAt(j, '.');
                            Board[i].setCharAt(j - 1, '.');
                        }
                    } // end if
                    if ((i + 1) < height && (j - 1) >= 0) {
                        x = Board[i].charAt(j);
                        y = Board[i + 1].charAt(j);
                        z = Board[i].charAt(j - 1);

                        if (x == '.' && y == '.' && z == '.') {
                            Board[i].setCharAt(j, '#');
                            Board[i + 1].setCharAt(j, '#');
                            Board[i].setCharAt(j - 1, '#');
                            ret += CoverBoard(Board, i);

                            Board[i].setCharAt(j, '.');
                            Board[i + 1].setCharAt(j, '.');
                            Board[i].setCharAt(j - 1, '.');
                        }
                    }
                } // end if

            } // end J for
        } // end I For
        return ret;
    }

}
