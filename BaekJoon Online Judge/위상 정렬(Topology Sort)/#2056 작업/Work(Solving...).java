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
    int endTime_ = 0;
    
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
        
        for (int i = 0; i < N; i++) if(dimen[i] == 0) q.add(work[i]);
        
        int max_time = 0;
        
        for (int i = 0; i < N; i++) {
            if(q.isEmpty()) return -1;
            Work now = q.poll();
            
            now.endTime_ += now.time_;
            max_time = Math.max(max_time, now.endTime_);
            
            now.preWork.stream().filter(next -> (--dimen[next] == 0)).map(next -> {
                //다음 작업의 종료 시간 = 이전 작업이 끝나는 시간 + 현재 작업에 소요되는 시간
                work[next].endTime_ = now.endTime_;
                return next;
            }).forEachOrdered(next -> { q.add(work[next]);});
        }
        
        return max_time;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Work[] work = new Work[N];
        int[] dimen = new int[N];
        
        /* 
        *  입력 형식
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
