package BFS.Baekjoon2458;

import java.util.*;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void bfs(int root, int[][] student){
        int std = student.length - 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for (int i = 1; i < std + 1; i++) {
                if(student[now][i] == 1 && student[i][root] != -1){
                    q.add(i);
                    student[i][root] = -1;
                    student[root][i] = 1;
                }
            }
        }
    }
    
    public static void printStatus(int std, int[][] student){
        for (int i = 1; i < std + 1; i++) {
            System.out.print(i + " : ");
            for (int j = 1; j < std + 1; j++) {
                System.out.print(student[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static int getStudent(int std, int[][] student){
        int result = 0;
        for (int i = 1; i < std + 1; i++) {
            bfs(i, student);
        }
        
        //printStatus(std, student);
        
        for (int i = 1; i < std + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < std + 1; j++) {
                if(student[i][j] == -1 || student[i][j] == 1) cnt++;
            }
            if(cnt >= std - 1) result++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int std = sc.nextInt();     // 2<= std <= 500
        int comp = sc.nextInt();    // 0 <= comp <= (500 * 499) / 2
        int[][] student = new int[std + 1][std + 1];
        //최대 학생 수 500
        //최대 비교 횟수 124,750
        
        for (int i = 0; i < comp; i++) {
            student[sc.nextInt()][sc.nextInt()] = 1;
        }
        
        System.out.println(getStudent(std, student));
    }
    
}
