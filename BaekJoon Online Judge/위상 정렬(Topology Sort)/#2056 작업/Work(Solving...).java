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
            System.out.print((now.index_+1) + " ");
            
            //선행 작업이 없는 작업은 어떻게 처리할 지 ?
            for (Integer next : now.preWork) {
                if (--dimen[next] == 0) {
                    //다음 작업의 종료 시간 = 이전 작업이 끝나는 시간 + 현재 작업에 소요되는 시간
                    work[next].endTime_ = now.endTime_ + work[next].time_;
                    q.add(work[next]);
                    max_time = Math.max(max_time, work[next].endTime_);
                }
            }
        }
        
        System.out.println("");
        return max_time;
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
            if(i == 0) work[i].endTime_ = work[i].time_; //첫번째 작업의 종료 시간을 설정(무조건 1번 작업이 처음이므로 시작 기준을 정해줘야함)
            
            for (int j = 0; j < preWork; j++){
                int w = sc.nextInt() - 1;       //w의 선행 작업이 i임
                work[w].preWork.add(i);
                dimen[i]++;
            }
        }
        
        
        System.out.println(topology(N, work, dimen));
    }
    
}
