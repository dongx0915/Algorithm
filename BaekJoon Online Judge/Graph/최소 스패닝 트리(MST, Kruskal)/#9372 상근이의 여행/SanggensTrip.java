import java.util.Scanner;

class Edge{
    int[] node = new int[2];

    public Edge(int x, int y) {
        this.node[0] = x;
        this.node[1] = y;
    }
}

public class Main {
    public static int getParent(int[] parent, int x){
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    
    public static void unionParent(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public static boolean checkCycle(int x, int y, int[] parent){
        x = getParent(parent, x);
        y = getParent(parent, y);
        return x == y;
    }
    
    public static int getFilght(Edge[] e, int[] parent){
        int cnt = 0;
        
        for (Edge edge : e) {
            if(!checkCycle(edge.node[0] - 1, edge.node[1] - 1, parent)){
                unionParent(edge.node[0] - 1, edge.node[1] - 1, parent);
                cnt++;
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        while(test-- != 0){
            int n = sc.nextInt();       //국가의 수
            int m = sc.nextInt();       //비행기 종류
            int[] parent = new int[n];
            Edge[] e = new Edge[m];
            
            for (int i = 0; i < n; i++)  parent[i] = i;
            for (int i = 0; i < m; i++) e[i] = new Edge(sc.nextInt(), sc.nextInt());

            System.out.println(getFilght(e, parent));
        }
    }
}
