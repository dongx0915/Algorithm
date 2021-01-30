/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetMeetingRoom;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Meeting implements Comparable<Meeting>{
    int start_time;
    int end_time;
    boolean selected = false;
    
    public Meeting(int start_time, int end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    @Override
    public int compareTo(Meeting o) {
        if(this.start_time > o.start_time)return 1;
        else if(this.start_time < o.start_time)return -1;
        else return 0;
    }
}



public class Main {

    /**
     * @param args the command line arguments
     */
    public static int getMaxMeeting(int n, Meeting[] meeting){
        int meet_cnt = 1;
        Meeting now_m = meeting[0];
        now_m.setSelected(true);
        
        for (int i = 0; i < n; i++) {
            Meeting next_m = meeting[i];
            if (next_m.selected) continue;

            
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
        //Arrays.sort(meeting);
        
        Arrays.sort(meeting, new Comparator<Meeting>(){
            @Override
            public int compare(Meeting m1, Meeting m2){
                if(m1.end_time > m2.end_time) return 1;
                else if(m1.end_time < m2.end_time) return -1;
                else return 0;
            }
        });
        
        Arrays.sort(meeting, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2){
                if(m1.start_time > m2.start_time) return 1;
                else if(m1.start_time < m2.start_time) return -1;
                else return 0;
            }
        });
        
        for (Meeting m : meeting) {
            System.out.println(m.start_time + " " + m.end_time);
        }
        
        System.out.println(getMaxMeeting(n, meeting));
    }
    
}
