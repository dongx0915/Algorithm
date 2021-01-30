/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetMeetingRoom;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Meeting implements Comparable<Meeting>{
    int start_time;
    int end_time;
    
    public Meeting(int start_time, int end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end_time == o.end_time) return this.start_time - o.start_time;
        return this.end_time - o.end_time;
    }
}



public class Main {

    /**
     * @param args the command line arguments
     */
    public static int getMaxMeeting(int n, Meeting[] meeting){
        int meet_cnt = 1;
        Meeting now_m = meeting[0];
        
        for (int i = 1; i < n; i++) {
            Meeting next_n = meeting[i];
            if(now_m.end_time <= next_n.start_time) {
                now_m = next_n;
                meet_cnt++;
            }
        }
 
        return meet_cnt;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Meeting[] meeting = new Meeting[n];
        
        for (int i = 0; i < n; i++) {
            meeting[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        
        Arrays.sort(meeting);
        
        System.out.println(getMaxMeeting(n, meeting));
    }
    
}
