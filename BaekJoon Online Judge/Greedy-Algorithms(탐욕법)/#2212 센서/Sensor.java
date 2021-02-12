package Greedy.Baekjoon2212;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Section implements Comparable<Section>{
    int value;          //센서 사이의 거리
    int rank = 1;   
    int index;
    public Section(int value, int index) {
        this.value = value;
        this.index = index;
    }
    
    @Override
    public int compareTo(Section o){
        return this.rank - o.rank;
    }
}

public class Main {
    public static int getReceiveableArea(int n, int k, int[] sensor){
        int[] index = new int[k];
        int[] section_int = new int[n - 1];
        Section[] section = new Section[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            section[i] = new Section(sensor[i + 1] - sensor[i], i); 
            section_int[i] = section[i].value;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if(section[i].value < section[j].value) section[i].rank++;
            }
        }
 
        Arrays.sort(section);
        
        for (int i = 0; i < k - 1; i++) {index[i] = section[i].index;}
        index[k - 1] = n - 1;
        
        Arrays.sort(index);
        
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if(i == index[cnt]){
                cnt++;
                continue;
            }
            sum += section_int[i];
        }

        
        return sum;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sensor = new int[n];
        
        for (int i = 0; i < n; i++) {
            sensor[i] = sc.nextInt();
        }
        
        Arrays.sort(sensor);
        if(n < k) System.out.println("0");
        else System.out.println(getReceiveableArea(n, k, sensor));
    }
    
}
