package SnakeAndLadderGame;

import java.util.*;

class Obstacle{
    int start;
    int end;
    public Obstacle(int start, int end){
        this.start = start;
        this.end = end;
    }
}


public class SnakeAndLadderGame{
    public static int ladderCnt, snakeCnt;
    public static ArrayList<Obstacle> obstacle;
    public static final int ARRIVE = 100;
    public static boolean[] visited = new boolean[106];                             //주사위는 최대 6까지이므로 도착 지점을 넘어가는 최댓값은 105
    
    public static int getArrivePos(int start){
        for (Obstacle pos : obstacle) if(pos.start == start) return pos.end;        //전달받은 인자(주사위를 굴려 이동할 위치)가 사다리나 뱀을 포함하고 있으면 도착지점 리턴
        return start;                                                               //아무것도 없으면 그냥 리턴
    }
    
    public static int MinDiceCntToBFS(){
        Queue<Integer> posit = new LinkedList<>();
        Queue<Integer> dice = new LinkedList<>();
        int diceCnt = 0;
        
        posit.add(1);                                       //시작지점 위치 삽입
        dice.add(diceCnt);                                  //주사위 횟수 삽입(0)
        
        while(!posit.isEmpty()){
            int nowPos = posit.poll();
            diceCnt = dice.poll();
            
            if(getArrivePos(nowPos) >= ARRIVE) break;       //현재 위치가 도착지점이면 break
            
            for (int i = 1; i <= 6; i++) {
                int arv = getArrivePos(nowPos + i);
                
                if(!visited[arv]){
                    posit.add(getArrivePos(nowPos + i));       //현재 위치에서 주사위를 굴렸을 때(1~6) 도착지점을 큐에 삽입
                    dice.add(diceCnt + 1);                     //주사위 횟수 +1
                    visited[arv] = true;
                }
            }
        }

        return diceCnt;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ladderCnt = sc.nextInt();
        snakeCnt = sc.nextInt();
        obstacle = new ArrayList<>();
        
        for(int i = 0; i < ladderCnt + snakeCnt; i++){
            obstacle.add(new Obstacle(sc.nextInt(), sc.nextInt()));
        }
        
        System.out.println(MinDiceCntToBFS());
    }
}
