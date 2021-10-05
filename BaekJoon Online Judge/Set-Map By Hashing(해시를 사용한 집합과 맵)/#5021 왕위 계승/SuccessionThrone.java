/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ5021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Donghyeon <20183188>
 */
class Parent{
    String p_,m_;
    
    public Parent(String p_, String m_) {
        this.p_ = p_;
        this.m_ = m_;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Parent) {
            Parent p = (Parent)o;
            //부모 순서가 바뀌어서 들어오는 경우까지 체크(부 <-> 모)
            return ((this.p_.equals(p.p_)) && (this.m_.equals(p.m_))) ||
                    ((this.p_.equals(p.m_) && this.m_.equals(p.p_)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.p_);
        hash = 53 * hash + Objects.hashCode(this.m_);
        return hash;
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N,M;
                  
    public static Hashtable<Parent, HashSet<String>> family = new Hashtable<>(); /* <부모 관계, 자식> */
    public static Hashtable<String, Integer> ancestor = new Hashtable<>();       /* <이름, 상위 관계 수> */
    public static Hashtable<String, Double> bloodLine = new Hashtable<>();    /* <이름, 혈통> */
    
    public static void addSortTarget(Queue<Parent> q){
        for (Map.Entry<Parent, HashSet<String>> entry : family.entrySet()) {
            Parent e = entry.getKey();
            if ((ancestor.getOrDefault(e.p_, 0) + ancestor.getOrDefault(e.m_, 0)) == 0) q.add(e);
        }
    }
    
    /*Topology Sort 이용*/
    public static String getNextKing(String king, ArrayList<String> nextKings){
        Queue<Parent> q = new LinkedList<>();
        bloodLine.put(king, 1.0);
        
        addSortTarget(q);
        
        HashSet<String> child;
        Iterator<String> iter;
        
        while(!q.isEmpty()){
            Parent p = q.poll();
            child = family.getOrDefault(p, null);
            
            if(child == null) continue;
            
            double bp = bloodLine.getOrDefault(p.p_, 0.0);
            double bm = bloodLine.getOrDefault(p.m_, 0.0);
            double bc = (bp + bm) / 2;
            
            iter = child.iterator();
            while(iter.hasNext()){
                String c = iter.next();
                bloodLine.put(c, bc);
                
                int idx = ancestor.get(c)-1;
                if(idx < 0) idx = 0;
                ancestor.put(c, idx);  //자식의 상위 관계 수 -1
            }
            
            //이미 계산한 부모 관계는 제거
            family.remove(p);
            
            //다시 상위 관계가 없는 부모 관계를 큐에 삽입
            addSortTarget(q);
        }
        
        //여기서 혈통의 값이 가장 큰 사람을 리턴하면 됨
        Double max = Double.MIN_VALUE;
        String nextKing = "";

        for (String next : nextKings) {
            if(bloodLine.containsKey(next)){
                if(max < bloodLine.get(next)){
                    max = bloodLine.get(next);
                    nextKing = next;
                }
            }
        }
        
        return nextKing;
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();   //가족 정보의 수
        M = sc.nextInt();   //왕위를 계상받기를 주장하는 사람 수
        
        String king = sc.next();
        String c; //자식
        Parent parent;
        HashSet<String> child;

        for (int i = 0; i < N; i++) {
            c = sc.next();
            parent = new Parent(sc.next(), sc.next());
            
            //부모 관계 밑에 자식을 추가
            child = family.getOrDefault(parent, new HashSet<>());
            child.add(c);
            
            family.put(parent, child);
            
            //자식의 상위 관계에 +1
            ancestor.put(c, ancestor.getOrDefault(c, 0) + 1);
        }
        
        ArrayList<String> nextKings = new ArrayList<>();
        for (int i = 0; i < M; i++)  nextKings.add(sc.next());
        
        System.out.println(getNextKing(king, nextKings));
    }
    
}
