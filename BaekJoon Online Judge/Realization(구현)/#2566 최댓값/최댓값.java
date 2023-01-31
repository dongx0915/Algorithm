import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int x = 0, y = 0;
		
		for(int i = 0; i < 81; i++){
		    int num = sc.nextInt();
		    if(max < num){
		        max = num; x = i / 9; y = i % 9;
		    }
		}
		System.out.println(max + "\n" + (x+1) + " " + (y+1));
	}
}