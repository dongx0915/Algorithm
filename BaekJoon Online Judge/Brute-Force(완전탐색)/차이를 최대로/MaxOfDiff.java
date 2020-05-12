import java.util.ArrayList;
import java.util.Scanner;

class myArray {

    int num;
    boolean isSelected = false;

    public myArray(int num) {
        this.num = num;
    }
}

public class Main {

    public static int getSum(ArrayList<Integer> picked) {
        int size = picked.size();
        int sum = 0;

        for (int i = 0; i < size - 1; i++) {
            sum += (int) Math.abs(picked.get(i) - picked.get(i + 1));
        }
        return sum;
    }

    public static int suppleArray(int n, myArray[] num, ArrayList<Integer> picked) {
        int sum = 0;
        if (picked.size() == n)sum = getSum(picked);
        else {
            for (int i = 0; i < n; i++) {
                if (num[i].isSelected == false) {
                    picked.add(num[i].num);
                    num[i].isSelected = true;

                    int subSum = suppleArray(n, num, picked);
                    if(sum < subSum) sum = subSum;

                    picked.remove(picked.size() - 1);
                    num[i].isSelected = false;
                }
            }
        }
        
        return sum;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> picked = new ArrayList<>();
        int n = sc.nextInt();
        myArray[] num = new myArray[n];
        
        for (int i = 0; i < n; i++) {
            num[i] = new myArray(sc.nextInt());
        }
        
        System.out.println(suppleArray(n, num, picked));
    }

}
