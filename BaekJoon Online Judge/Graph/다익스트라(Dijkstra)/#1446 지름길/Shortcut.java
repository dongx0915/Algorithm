/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstra.Baekjoon1446;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class ShortCut implements Comparable<ShortCut>{
    int start;
    int end;
    int distance;

    public ShortCut(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(ShortCut o){
        return this.start - o.start;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static final int INF = Integer.MAX_VALUE;
    public static int[] moved_distance;     //해당 위치까지의 최단 거리를 저장하는 배열
    public static ShortCut[] shortcut;
    
    public static int dijkstra(int start, int end, int n){
        moved_distance[start] = 0;
        
        int now_shortcut = 0;   //지름길 인덱스
        int now_distance = 0;   //현재까지 온 거리
        
        while(now_distance < end){
            while(now_shortcut < n){
                //아직 방문하지 않은 지름길 중 가장 먼저나오는 지름길이 현재 위치와 다르면 break
                //지름길의 시작점과 현재 위치가 다른 경우에 멈추므로 시작점이 같은 지름길을 모두 체크할 수 있음
                if(shortcut[now_shortcut].start != now_distance) break;
                
                //지름길이 고속도로의 범위 안에 있는 경우(역주행이 불가능하므로 범위를 벗어나면 탈 수 없음)
                if(shortcut[now_shortcut].end <= end){
                    /*
                    * 지름길의 도착 지점까지의 최단 거리보다 (현재 위치(now_distance)까지의 최단 거리 + 지름길)의 경우가 
                    * 더 짧으면 갱신해줌
                    */
                    
                    int use_shortcut = moved_distance[now_distance] + shortcut[now_shortcut].distance; //지름길을 타는 경우의 거리
                    if(moved_distance[shortcut[now_shortcut].end] > use_shortcut){
                        moved_distance[shortcut[now_shortcut].end] = use_shortcut;
                    }
                }
                now_shortcut++;
            }
            
            //현재 위치에서 바로 다음 위치로 가는 경우가 더 최단 거리라면 다음 위치의 최단 거리 값을 갱신
            if (moved_distance[now_distance] + 1 < moved_distance[now_distance + 1]) {
                moved_distance[now_distance + 1] = moved_distance[now_distance] + 1;
            }
            
            now_distance++;
        }
        
        return moved_distance[end];
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       //지름길의 개수
        int d = sc.nextInt();       //고속도로의 길이(도착 지점)
        
        moved_distance = new int[d + 1];
        shortcut = new ShortCut[n];
        
        for (int i = 0; i < n; i++) {
            shortcut[i] = new ShortCut(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        
        Arrays.sort(shortcut);
        Arrays.fill(moved_distance, INF);
        
        System.out.println(dijkstra(0, d, n));
    }
    
}
