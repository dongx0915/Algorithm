/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Silver.BOJ10828;
import java.io.*;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static int[] stack;
    public static int size = 0;
    public static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        int n = Integer.parseInt(str);
        
        stack = new int[n];
        
        while((n--) != 0){
            String[] command = br.readLine().split(" ");

            if("push".equals(command[0])){
                int num = Integer.parseInt(command[1]);
                push(num);
            }
            else if ("pop".equals(command[0])) pop();
            else if ("size".equals(command[0])) size();
            else if ("empty".equals(command[0])) empty();
            else if ("top".equals(command[0])) top();
        }
        
        bw.flush();
    }
    
    public static void push(int n){
        stack[size++] = n;
    }
    
    public static void pop() throws IOException{
        if(size == 0) bw.write("-1\n");
        else{
            bw.write(stack[size-1] + "\n");
            stack[size - 1] = 0;
            size--;
        }
    }
    
    public static void size() throws IOException{
        bw.write(size + "\n");
    }
    
    public static void empty() throws IOException{
        if(size == 0) bw.write("1\n");
        else bw.write("0\n");
    }
    
    public static void top() throws IOException{
        if(size == 0) bw.write("-1\n");
        else bw.write(stack[size - 1] + "\n");        
    }
    
}
