
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      	int n = in.nextInt();
      	// int m = in.nextInt();
      	int[] nums = new int[n];
      	for (int j=0; j<n; j++){
      		nums[j] = in.nextInt();
      	}
        int result = 0;
        Arrays.sort(nums);
        for(int k=0; k<n-2; k++){
            int low = k+1, high = k+2, sum = nums[k];
            while(high < n){
                if(sum * nums[low] == nums[high]){
                    // System.out.print(sum + " ");
                    // System.out.println(nums[low]);
                    result++;
                    while (low==high){high++;} 
                    low++;
                    high++;
                }else if(sum * nums[low] < nums[high]){
                    low ++; high++;
                }else{
                    high++;;
                }
            }
        }
    	System.out.println("Case #" + i + ": " + String.valueOf(result));
    }
  }
}