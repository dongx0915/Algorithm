import java.util.ArrayList;
import java.util.Scanner;

class LottoNum {
    int num;
    boolean isSelected = false;

    public LottoNum(int num) {
        this.num = num;
    }
}

public class Main {

    public static void printLotto(ArrayList<Integer> picked) {
        int size = picked.size();
        for (int i = 0; i < size; i++) {
            if(i == size - 1) System.out.printf("%d\n", picked.get(i));
            else System.out.printf("%d ", picked.get(i));
        }
    }

    public static void LottoPermutation(int k, LottoNum[] num, ArrayList<Integer> picked, int pickCnt) {
        if (picked.size() == 6) {
            printLotto(picked);
            return;
        }
        
        int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1);
        
        for (int i = 0; i < k; i++) {
            if (num[i].isSelected == false && num[i].num > smallest) {
                num[i].isSelected = true;
                picked.add(num[i].num);

                LottoPermutation(k, num, picked, pickCnt - 1);

                num[i].isSelected = false;
                picked.remove(picked.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> picked = new ArrayList<>();
        int loopCnt = 0;
        
        while ((++loopCnt) != 0) {
            int k = sc.nextInt();
            if (k == 0) break;
            if(loopCnt != 1) System.out.println("");
            
            LottoNum[] num = new LottoNum[k];

            for (int i = 0; i < k; i++) {
                num[i] = new LottoNum(sc.nextInt());
            }
            
            LottoPermutation(k, num, picked, 6);
            
        }
    }
}
