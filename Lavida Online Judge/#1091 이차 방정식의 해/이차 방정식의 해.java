import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test, a, b, c;
        test = sc.nextInt();
        for(int i = 0; i<test; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if((b*b - 4 *a*c)>0){
                System.out.println("This Equation has two answers");
                }
            else if((b*b - 4 *a*c)==0){
                System.out.println("This Equation has only one answer");
            }
            else if((b*b - 4 *a*c)<0){
                System.out.println("This Equation has no answer");
            }
        }
    }
}