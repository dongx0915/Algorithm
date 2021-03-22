import java.util.*;

public class Main {
    public static long getMinimumCost_array(long[] nums, int sum) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) result += nums[i] * (sum -= nums[i]);

        return result;
    }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        long[] nums = new long[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        System.out.println(getMinimumCost_array(nums, sum));
    }
}
