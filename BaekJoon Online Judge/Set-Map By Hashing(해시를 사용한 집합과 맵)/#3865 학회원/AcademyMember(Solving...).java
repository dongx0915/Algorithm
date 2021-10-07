/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash.BOJ3865;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Donghyeon <20183188>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static int N;
    public static Hashtable<String, HashSet<String>> academy_table;
    
    public static String getMembers(String name, HashSet<String> members){
        if(academy_table.containsKey(name)){ //학회 이름이라면
            String[] mem = (String[])academy_table.get(name).toArray();
            for (String m : mem) members.add(getMembers(m, members));
        }
        return name;
    }
    
    public static void solution(){
        HashSet<String> members;

        for (Map.Entry<String, HashSet<String>> entry : academy_table.entrySet()) {
            members = entry.getValue();
            Iterator<String> iter = members.iterator();
            
            while(iter.hasNext()){
                String member = iter.next();

            }
        }
        
        while (st.hasMoreTokens()) {
            String member = st.nextToken();
            if (academy_table.containsKey(member)) {
                members.addAll(academy_table.get(member));
            } else {
                members.add(member);
            }
        }
        academy_table.put(academy, members);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        academy_table = new Hashtable<>();
        
        //학회 : 학회원(멤버) .
        while((N = sc.nextInt()) != 0){
            String result = "";
            HashSet<String> member;
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(sc.next(), "[:,.]");
                String academy = st.nextToken();
                if(i == 0) result = academy;
                member = academy_table.getOrDefault(academy, new HashSet<>());
                
                while(st.hasMoreTokens()) member.add(st.nextToken());
                academy_table.put(academy, member);
            }
            
            System.out.println(academy_table.get(result).size());
        }
    }
    
}
