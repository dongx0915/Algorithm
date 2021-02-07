import java.util.*;

class Jewelry implements Comparable<Jewelry>{
    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    
    @Override
    public int compareTo(Jewelry o){
        return (this.value < o.value) ? 1 : ((this.value == o.value) ? 0 : -1);
    }
}

public class Main {
    public static long getMaxPrice(int n, int k, int[] bag, Jewelry[] jw){
        long result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if(bag[j] == -1) continue;
                if(jw[i].weight <= bag[j]){
                    bag[j] = -1;
                    result += jw[i].value;
                    break;
                }
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 보석의 개수
        int k = sc.nextInt();       // 가방의 개수
        int[] bag = new int[k];
        Jewelry[] jw = new Jewelry[n];
        
        for (int i = 0; i < n; i++)jw[i] = new Jewelry(sc.nextInt(), sc.nextInt());
        for (int i = 0; i < k; i++)bag[i] = sc.nextInt();

        Arrays.sort(jw);
        Arrays.sort(bag);
        
        System.out.println(getMaxPrice(n,k,bag,jw));
    }
}
