/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
class Deque{
    private final int[] array;
    private final int max_size;
    private int size;       //덱에 들어있는 데이터의 수
    private int front;      //front 포인터
    private int back;       //back 포인터
    
    public Deque(){
        this.array = new int[10000];
        this.max_size = this.array.length;
        this.size = 0;
        this.front = 0;
        this.back = 0;
    }
    
    public void push_front_X(int data){
        if(size >= max_size) return;
        if(size == 0) back = (front + 1) % max_size;
        array[front] = data;
        
        front--;
        if(front < 0) front = max_size - 1;
        size++;
    }
    
    public void push_back_X(int data){
        if(size >= max_size) return;
        if(size == 0) front = (back - 1) < 0 ? max_size - 1 : (back - 1);
        
        array[back] = data;
        back = (back + 1) % max_size;
        size++;
    }
    
    public int pop_front(){
        if(size <= 0) return -1;
        
        front = (front + 1) % max_size;
        size--;

        return array[front];
    }
    
    public int pop_back(){
        if(size <= 0) return -1;
        
        back--;
        if(back < 0) back = max_size - 1;
        size--;
        
        return array[back];
    }
    
    public int size(){
        return this.size;
    }
    
    public int empty(){
        return this.size == 0 ? 1 : 0;
    }
    
    public int front(){
        if(size == 0) return -1;
        
        return array[(front + 1) % max_size];
    }
    
    public int back(){
        if(size == 0) return -1;
        
        return (back - 1) < 0 ? array[max_size - 1] : array[back - 1];
    }
}

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        Deque dq = new Deque();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd){
                case "push_front" : 
                    dq.push_front_X(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    dq.push_back_X(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    System.out.println(dq.pop_front());
                    break;
                case "pop_back" :
                    System.out.println(dq.pop_back());
                    break;
                case "size"  :
                    System.out.println(dq.size());
                    break;
                case "empty" :
                    System.out.println(dq.empty());
                    break;
                case "front" :
                    System.out.println(dq.front());
                    break;
                case "back" :
                    System.out.println(dq.back());
                    break;
                default : 
                    break;
            }
        }
        
    }
    
}
