import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Donghyeon <20183188>
 */

class Node{
    int num;
    ArrayList<Integer> friends = new ArrayList<>();

    public Node(int num) {
        this.num = num;
    }
}

public class Main {
    
    public static boolean isAllFriend(int n, Node[] people){
        for(int i = 1; i < n + 1; i++){
            if(people[i].friends.size() != n - 1) return false;
        }
        return true;
    }
    
    public static int bfs(Node[] people, int root){
        int new_fs = 0;
        //System.out.println(root + "번 사람");
        int size = people[root].friends.size();
        
        for (int i = 0; i < size; i++) {
            int friend = people[root].friends.get(i);
            //System.out.println(root + "의 친구 : " + friend);
            
            for (int j = 0; j < people[friend].friends.size(); j++) {
                int next = people[friend].friends.get(j);
                //System.out.println("그 친구의 친구 : " + next);
                
                if(!people[root].friends.contains(next)){
                    //System.out.println("새 친구 !");
                    people[root].friends.add(next);
                    new_fs++;
                }
            }
        }
//        for (Integer friend : people[root].friends) {
//            System.out.println(root + "의 친구 : " + friend);
//            for (Integer next : people[friend].friends) {
//                System.out.println(friend + "의 친구 : " + next);
//                if(!people[root].friends.contains(next)){
//                    people[root].friends.add(friend);
//                    new_fs++;
//                }
//            }
//        }
        
        //System.out.println("--------------------------------");
        return new_fs;
    }
    
    public static void calc_friendship(int n, Node[] people){
        StringBuilder sb = new StringBuilder();
        int day = 0;
        
        //새로운 관계가 하나도 안생기면 모두 친구가 된 것
        while(true){
            int new_fs = 0;
            for (int i = 1; i < n + 1; i++) {
                new_fs += bfs(people, i);
            }
            //System.out.println(new_fs);
            //System.out.println("------------------------------------");
            if(new_fs == 0) break;
            sb.append(new_fs).append("\n");
            day++;
        }
        //}
        
        System.out.println(day);
        System.out.print(sb.toString());
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int friendship = sc.nextInt();
        Node[] people = new Node[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            people[i] = new Node(i);
        }
        
        for (int i = 0; i < friendship; i++) {
            people[sc.nextInt()].friends.add(sc.nextInt());
        }
        calc_friendship(n, people);
    }
    
}
