import java.util.*;

class Menus {

    String MenuName;
    int price;
}

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here

        int test = scan.nextInt();

        for (int i = 0; i < test; i++) {
            int juiceCount = scan.nextInt();
            int choice = scan.nextInt();
            Menus[] m = new Menus[juiceCount];
            InstanceInit(m, juiceCount);
            
            String[] choiceMenu = new String[choice];

            for (int j = 0; j < juiceCount; j++) {
                m[j].MenuName = scan.next();
                m[j].price = scan.nextInt();
            }

            for (int k = 0; k < choice; k++) {
                choiceMenu[k] = scan.next();
            }
            ChangeCalculator(m, choiceMenu, juiceCount, choice);
        }

    }
    public static <T> void InstanceInit(Menus[] m, int size){
        for(int i = 0; i < size; i++){
            m[i] = new Menus();
        }
    }
    public static void ChangeCalculator(Menus[] m, String[] choiceMenu, int juiceCount, int choice) {
        int sum = 0;
        int[] money = {10000, 5000, 1000};
        int[] coin = {500, 100};
        
        for (int i = 0; i < choice; i++) {
            for (int j = 0; j < juiceCount; j++) {
                if (choiceMenu[i].equals(m[j].MenuName)) {
                    sum += m[j].price;
                    break;
                }
            }
        }
        
        int moneyCnt = money.length;
        int coinCnt = coin.length;
        int minPay = 0;
        int minMoneyCnt = 0;
        int change = 0;
        int saveChange = 0;
        int ChangeCoin = 0;
        int saveSum = sum;
        int saveMinPay  = 0;
        //minPay == bill
        //minMoneyCnt == bill count
        
        saveMinPay = minPay = ((sum % 1000) != 0) ? (sum + (1000 - (sum % 1000))) : sum;
           
        for(int k = 0; k < moneyCnt; k++){
            if(minPay >= money[k]){
                minMoneyCnt += (minPay / money[k]);
                minPay -= (minPay / money[k]) * money[k];
            }
        }
        
        if(saveMinPay != 0)change = saveMinPay - saveSum;
        saveChange = change;
        
        for(int l = 0; l < coinCnt; l++){
            if(change / coin[l] == 0) continue;
            else {
                ChangeCoin += change / coin[l];
                change -= (change / coin[l]) * coin[l];
            }
        }
        System.out.println(saveSum + " " + saveMinPay + " " + minMoneyCnt + " " + saveChange + " " + ChangeCoin);
    }
}