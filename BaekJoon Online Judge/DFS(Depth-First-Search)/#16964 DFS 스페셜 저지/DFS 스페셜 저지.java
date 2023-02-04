import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Node{
    boolean visited_ = false;
    HashSet<Integer> child = new HashSet<>();
}

public class Main {
    public static Node[] node;
    public static int[] order;
    public static int n, idx = 1;
        
    public static void dfs(int parent, int curNode){
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : node[curNode].child) if(i != parent) set.add(i);
        
        int len = set.size();
        if(len == 0) return;
        
        // 현재 노드의 자식들을 통해서 다음 order로 갈 수 있는지만 체크하는 반복문
        while(len > 0){ 
            int next = order[idx];
            // 현재 노드에서 다음 order로 갈 수 있는 자식이 있으면 dfs 진입
            if(!node[next].visited_ && set.contains(next)){
                idx++;
                node[next].visited_ = true;
                dfs(curNode, next); 
                len--;
            }
            else break; // 없으면 바로 종료
        }
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        node = new Node[n + 1];
        
        for (int i = 0; i < n+1; i++) node[i] = new Node();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(!node[n1].child.contains(n2)) {
                node[n1].child.add(n2);
                node[n2].child.add(n1);
            }
        }
        
        String[] input = br.readLine().split(" ");
        
        order = new int[n];
        for(int i = 0; i < input.length; i++) 
            order[i] = Integer.parseInt(input[i]);
        
        if(order[0] == 1){
            node[1].visited_ = true;
            dfs(-1, 1);
        }
        
        System.out.println((idx == n ? 1 : 0));
    }
}