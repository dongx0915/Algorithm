import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
    public static int topology(int N, Work[] work, int[] dimen){
        Queue<Work> q = new LinkedList<>();
        
        for (int i = 0; i < N; i++) if(dimen[i] == 0) q.add(work[i]);
        
        int max_time = 0;
        
        for (int i = 0; i < N; i++) {
            if(q.isEmpty()) return -1;
            Work now = q.poll();
            
            /*현재 작업(now)가 끝나는 시간을 갱신
            * endTime_은 이전 작업이 끝나는 시간으로 셋팅되어 있으므로 
            * endTime_에 time_(현재 작업의 소요 시간)을 더해주면 현재 작업의 끝나는 시간이 됨
            */
            now.endTime_ += now.time_;
            max_time = Math.max(max_time, now.endTime_);
            
            for (Integer next: now.preWork) {
                if(--dimen[next] == 0) q.add(work[next]);
                
                work[next].endTime_ = Math.max(work[next].endTime_, now.endTime_);
            }
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
