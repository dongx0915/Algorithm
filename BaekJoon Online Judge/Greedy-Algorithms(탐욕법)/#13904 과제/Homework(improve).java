import java.util.Arrays;
import java.util.Scanner;

class Homework implements Comparable<Homework>{
    int deadline;
    int score;

    public Homework(int deadline, int score) {
        this.deadline = deadline;
        this.score = score;
    }
    
    @Override
    public int compareTo(Homework o){
        return o.score- this.score;
    }
}

public class Main {
    public static int[] homework_day;
    
    public static int getMaxScore(int max_dead, Homework[] hw){
        int sum = 0;
        
        for (Homework h : hw) {
            for (int i = h.deadline; i > 0; i--) {
                if(homework_day[i] == 0){
                    homework_day[i] = h.score;
                    break;
                }
            }
        }
        
        for (int i : homework_day) sum += i;
        return sum;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max_dead = -1;
        Homework[] hw = new Homework[n];

        for (int i = 0; i < n; i++) {
            hw[i] = new Homework(sc.nextInt(), sc.nextInt());
            max_dead = Math.max(max_dead, hw[i].deadline);
        }
        
        homework_day = new int[max_dead + 1];
        Arrays.sort(hw);
        System.out.println(getMaxScore(max_dead, hw));
    }
    
}
