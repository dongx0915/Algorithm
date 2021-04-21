/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MST.Baekjoon14621;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class University implements Comparable<University>{
    int[] university_ = new int[2];
    int distance_;

    public University(int univ1, int univ2, int distance) {
        this.university_[0] = univ1;
        this.university_[1] = univ2;
        this.distance_ = distance;
    }
    
    @Override
    public int compareTo(University u){
        return this.distance_ - u.distance_;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    
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
    
    public static int getAppsPathLength(ArrayList<University> univ, int[] parent, String[] sex_info){
        int univ_cnt = parent.length;
        int path_length = 0;
        int connect_cnt = 0;
        
        for (University u : univ) {
            if(!checkCycle(u.university_[0] - 1, u.university_[1] - 1, parent)){
                if(!sex_info[u.university_[0] - 1].equals(sex_info[u.university_[1] - 1])){
                    //System.out.println(u.university_[0] + " - " + u.university_[1] + " : " + u.distance_);
                    path_length += u.distance_;
                    unionParent(u.university_[0] - 1, u.university_[1] - 1, parent);
                    connect_cnt++;
                }
            }
        }
        
        return ((univ_cnt - 1)== connect_cnt) ? path_length : -1;
    }
    
    public static void main(String[] args){
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //학교(정점)의 수
        int m = sc.nextInt();       //도로(간선)의 수
        int[] parent = new int[n];
        ArrayList<University> univ = new ArrayList<>();

        //버퍼 초기화
        sc.nextLine();
        
        //M = 남초, W = 여초
        String[] sex_info = sc.nextLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            univ.add(new University(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(univ);
        System.out.println(getAppsPathLength(univ, parent, sex_info));
    }
    
}
