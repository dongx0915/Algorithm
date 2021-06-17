/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deque;

/**
 *
 * @author Donghyeon <20183188>
 */
class Deque{
    int[] array;
    int max_size;
    int size;       //덱에 들어있는 데이터의 수
    int front;      //front 포인터
    int back;       //back 포인터
    
    public Deque(){
        this.array = new int[10000];
        this.max_size = this.array.length;
        this.size = 0;
        this.front = 1;
        this.back = 0;
    }
    
    public void push_front_X(int data){
        if(size >= 10000) return;
        
        front--;
        if(front < 0) front = this.array.length - 1;

        array[front] = data;
    }
    
    public void push_back_X(int data){
        if(size >= 10000) return;
        
        array[back] = data;
        back = (back + 1) % max_size;
    }
    
    public int pop_front(){
        if(size <= 0) return -1;
        int pop = array[0];
        
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        return pop;
    }
    
    public int pop_back(){
        return -1;
    }
    
    public int size(){
        return this.size;
    }
    
    public boolean empty(){
        return this.size == 0;
    }
    
    public int front(){
        return this.array[this.front];
    }
    
    public int back(){
        return this.array[this.size - 1];
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
