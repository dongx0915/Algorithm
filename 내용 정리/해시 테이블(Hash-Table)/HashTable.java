/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTable;

import java.util.LinkedList;

/**
 *
 * @author Donghyeon <20183188>
 */
class HashTable{
    class Node{
        String key_;
        String value_;

        public Node(String key, String value) {
            this.key_ = key;
            this.value_ = value;
        }
        
        String value(){             //get
            return value_;
        }
        void value(String value){   //set
            this.value_ = value;
        }
    }
    
    LinkedList<Node>[] data_;
    
    HashTable(int size){ this.data_ = new LinkedList[size];}
    
    //key값을 HashCode로 변환해주는 메소드
    int getHashCode(String key){
        int hashcode = 0;
        
        for (char c : key.toCharArray()) hashcode += c;
        return hashcode;
    }
    
    //HashCode를 Index로 변환해주는 메소드
    int convertToIndex(int hashcode){ return hashcode % this.data_.length; }
    
    //key를 가지고 데이터를 찾는 메소드
    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for (Node node : list) {
            if(node.key_.equals(key)) return node;
        }
        
        return null;
    }
    
    //key와 value를 받아 데이터를 추가하는 메소드
    void put(String key, String value){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data_[index]; //인덱스로 기존 배열방의 데이터를 가져옴
        
        if(list == null){
            list = new LinkedList<>();
            data_[index] = list;
        }
        
        Node node = searchKey(list, key);
        //노드가 null이면 값을 추가
        if(node == null) list.addLast(new Node(key, value));
        //노드가 null이 아니면 값을 대체하여 중복키 처리
        else node.value(value);
    }
    
    //Key로 데이터를 가져오는 메소드
    String get(String key){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data_[index];
        Node node = searchKey(list, key);
        
        return node == null ? "Not Found" : node.value();
    }
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashTable h = new HashTable(3);
        
        h.put("sung", "She is pretty");
        h.put("jin", "She is a model");
        h.put("hee", "She is an angel");
        h.put("min", "She is cute");
        h.put("sung", "She is beautiful");
        
        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
        System.out.println(h.get("jae"));
    }
    
}
