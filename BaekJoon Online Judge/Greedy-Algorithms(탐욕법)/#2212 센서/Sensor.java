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
        
        for (int i = 0; i < k - 1; i++) {index[i] = section[i].index;}  //기준이 될 인덱스를 배열에 저장
        index[k - 1] = n - 1;                                           //마지막 인덱스를 저장해줌        
                                                                        //[0, 1, 5] 이면 (0,1) + (2,5)가 됨
        Arrays.sort(index);
        
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if(i == index[cnt]){           // (0<= i < 1) + (2 <= i < 5) 처럼 더해져야 하므로 현재 i가 index[cnt](기준 인덱스)와 같아지면 
                cnt++;                     // 거리를 더하지 않고 넘어간다. 추가로 인덱스도 하나 시켜준다.(다음 기준 인덱스로 설정)
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
        if(n < k) System.out.println("0");      //센서의 개수보다 집중국의 개수가 많은 경우는 각 센서마다 집중국을 설치하면 되므로 무조건 거리의 합은 0이 된다.
        else System.out.println(getReceiveableArea(n, k, sensor));
    }
    
}
