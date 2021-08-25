/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopologySort.BOJ2056;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Work{
    int index_;
    int time_;
    ArrayList<Integer> preWork;

    public Work(int index_) {
        this.index_ = index_;
        this.preWork = new ArrayList<>();
    }
    
}
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static int topology(int N, Work[] work, int[] dimen){
        Queue<Work> q = new LinkedList<>();
        int[] saveDimen = new int[N];
        
        for (int i = 0; i < N; i++) {
            saveDimen[i] = dimen[i];
            if(dimen[i] == 0) q.add(work[i]);
        }
        
        int time = 0, max_time = 0, preDimen = 0;
        
        for (int i = 0; i < N; i++) {
            if(q.isEmpty()) return -1;
            Work now = q.poll();
            
            if(preDimen != saveDimen[now.index_]) {     //차수가 달라지면 시간 최대값을 더해주고 초기화
                max_time += time;                       //차수가 달라진다는 것은 선행 작업 수가 다르다는 뜻
                time = now.time_;                       //즉, 차수가 같다는 것은 동시에 시작할 수 있다는 뜻임
            }
            else time = Math.max(time, now.time_);      //시간 최대값 저장
            
            preDimen = saveDimen[now.index_];
            now.preWork.forEach(next -> {if(--dimen[next] == 0) q.add(work[next]);});
        }
            
        return time == 0 ? max_time : max_time + time;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Work[] work = new Work[N];
        int[] dimen = new int[N];
        
        /* 입력 형식
        *  시간 : 선행 작업 수 : 선행 작업 번호(선행 작업 수만큼)
        */
        for (int i = 0; i < N; i++) work[i] = new Work(i);
        
        for (int i = 0; i < N; i++) {
            work[i].time_ = sc.nextInt();
            int preWork = sc.nextInt();
            
            for (int j = 0; j < preWork; j++){
                int w = sc.nextInt() - 1;       //w의 선행 작업이 i임
                work[w].preWork.add(i);
                dimen[i]++;
            }
        }

        System.out.println(topology(N, work, dimen));
    }
    
}
