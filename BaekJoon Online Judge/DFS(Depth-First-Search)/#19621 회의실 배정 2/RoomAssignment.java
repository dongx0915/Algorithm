import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    int s_;
    int e_;
    int p_;

    public Lecture(int s_, int e_, int p_) {
        this.s_ = s_;
        this.e_ = e_;
        this.p_ = p_;
    }
    
    @Override
    public int compareTo(Lecture l){
        return l.p_ - this.p_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int max_people = Integer.MIN_VALUE;
    public static boolean[] visited;
    public static int N;
    public static ArrayList<Lecture> lectures;

    public static boolean isSelectable(Lecture target, ArrayList<Lecture> selected){
        for (Lecture lecture : selected)
            if(target.e_ > lecture.s_ && lecture.e_ > target.s_) return false;

        return true;
    }
    
    public static int dfs(Lecture first, ArrayList<Lecture> selected, int people){
        
        for (int i = 0; i < N; i++) {
            Lecture next = lectures.get(i);

            if(visited[i]) continue;
            if(!isSelectable(next, selected)) continue;

            selected.add(next);
            visited[i] = true;
            
            max_people = Math.max(max_people, dfs(next, selected, people + next.p_));
            
            selected.remove(selected.size() - 1);
            visited[i] = false;
            
        }
        max_people = Math.max(max_people, people);
        return max_people;
    }
    
    public static int getMaxPeople(){
        int people = 0;
        ArrayList<Lecture> selected = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            Lecture root = lectures.get(i);
            
            selected.clear();
            selected.add(root);

            visited[i] = true;
            people = Math.max(people, dfs(root, selected, root.p_));
            visited[i] = false;
        }
        
        return people;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        lectures = new ArrayList<>();
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++)
            lectures.add(new Lecture(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        
        Collections.sort(lectures);
        System.out.println(getMaxPeople());
        //인원이 많은 순으로 내림차순 정렬
        //겹치지 않는 회의 중 가장 인원이 많은 것을 뽑음
    }
}
