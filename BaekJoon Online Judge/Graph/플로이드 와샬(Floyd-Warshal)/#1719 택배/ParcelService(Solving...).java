import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static final long INF = 200 * 10000 * 1000 + 1;
    public static int N,M;
    public static long[][] parcel;
    public static int[][] init, through;
    
    public static void floyd(){
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == k || j == k || i == j) continue;
                    if(parcel[i][j] > parcel[i][k] + parcel[k][j]) parcel[i][j] = Math.min(parcel[i][j], parcel[i][k] + parcel[k][j]);
                }
            }
        }
    }
    
    public static void print(int[][] array){
        StringJoiner sj = new StringJoiner(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) sb.append("- ");
                else sb.append(through[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    
    public static void setThrough(){
        for (int i = 0; i < N; i++) {      //출발 노드 for문
            for (int j = 0; j < N; j++) {  //도착 노드 for문
                if(i == j) continue;
                int minDis = Integer.MAX_VALUE;
                int minIndex = -1;
                
                for (int k = 0; k < N; k++) { //인접 노드 for문
                    if(init[i][k] == INF || i == k) continue;//출발 노드와 인접한 노드인지 체크
                    //k -> j가 최소인 노드 k가 가장 먼저 거쳐야하는 노드
                    
                    if(minDis > init[i][k] + parcel[k][j]){
                        minDis = (int)(init[i][k] + parcel[k][j]);
                        minIndex = k;
                    }
                }
                through[i][j] = minIndex+1;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());   //집하장 개수(1 <= N <= 200)
        M = Integer.parseInt(st.nextToken());   //경로 개수 (1 <= M <= 10000)
        
        parcel = new long[N][N];
        init = new int[N][N];
        through = new int[N][N];
        
        for (int i = 0; i < N; i++){
            Arrays.fill(parcel[i], INF);
            Arrays.fill(init[i], (int)INF);
            parcel[i][i] = init[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken())-1;
            int n2 = Integer.parseInt(st.nextToken())-1;
            
            parcel[n1][n2] = parcel[n2][n1] = init[n1][n2] = init[n2][n1] = Integer.parseInt(st.nextToken());
        }
        
        floyd();
        setThrough();
        print(through);
    }
}
