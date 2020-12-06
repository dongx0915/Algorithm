import java.util.*;

public class Main {

    static int height = 0;
    static int weight = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        for (int i = 0; i < test; i++) {
            height = scan.nextInt();
            weight = scan.nextInt();
            String[] input = new String[height];
            StringBuilder[] mine = new StringBuilder[height];
            int index = 0;

            for (int j = 0; j < height; j++) {
                input[j] = scan.next();
            }

             //Set input String to StringBuilder
            for (String str : input) {
                mine[index++] = new StringBuilder(str);
            }

            for (int k = 0; k < height; k++) {
                for (int s = 0; s < weight; s++) {
                    char c = input[k].charAt(s);
                    if (c == '*') {
                        DangerRange(mine, k, s);
                    } else if (c == '#') {
                        VeryDangerRange(mine, k, s);
                    }
                }
            }
           
            for (int l = 0; l < height; l++) {
                System.out.println(mine[l].toString().replace('.', '0'));
            }
        }
    }

    public static void DangerRange(StringBuilder[] mine, int column, int row) {

        for (int i = column - 1; i <= column + 1; i++) {
            if (i < 0 || i >= height) {
                continue;
            }
            for (int j = row - 1; j <= row + 1; j++) {
                if (j < 0 || j >= weight) {
                    continue;
                }
                if(mine[i].charAt(j) == '.') mine[i].setCharAt(j, '1');
            }
        }
    }

    public static void VeryDangerRange(StringBuilder[] mine, int column, int row) {
        for (int i = column - 2; i <= column + 2; i++) {
            if (i < 0 || i >= height) {
                continue;
            }
            for (int j = row - 2; j <= row + 2; j++) {
                if (j < 0 || j >= weight) {
                    continue;
                }
                if(mine[i].charAt(j) == '.') mine[i].setCharAt(j, '1');
            }
        }
    }
}