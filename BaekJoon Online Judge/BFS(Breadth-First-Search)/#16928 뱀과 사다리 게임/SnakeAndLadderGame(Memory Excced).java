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
    public static int ladderCnt;
    public static int snakeCnt;
    public static ArrayList<Obstacle> obstacle;
    public static final int ARRIVE = 100;
    
    public static int getArrivePos(int start){
        for (Obstacle pos : obstacle) if(pos.start == start) return pos.end;
        return start;
    }
    
    public static int MinDiceCntToBFS(){
        Queue<Integer> posit = new LinkedList<>();
        Queue<Integer> dice = new LinkedList<>();
        int diceCnt = 0;
        
        posit.add(1);
        dice.add(diceCnt);
        
        while(!posit.isEmpty()){
            int nowPos = posit.poll();
            diceCnt = dice.poll();
            
            if(getArrivePos(nowPos) >= ARRIVE) break;
            
            for (int i = 1; i <= 6; i++) {
                posit.add(getArrivePos(nowPos + i));
                dice.add(diceCnt + 1);
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
