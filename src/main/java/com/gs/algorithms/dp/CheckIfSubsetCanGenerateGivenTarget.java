package dynamic.programming;

public class CheckIfSubsetCanGenerateGivenTarget {
	/*
	 dynamic program tabulation
	   -> row as sum
	   -> col as given val
	   -  to fill value each cell
	      upto N , fill what it come from prev or false
	      if prev (-1 , 0) is true , the cell value is true too
	        otherwise go back to N steps back of pre row and set
	         
	   0 1 2 3 4 5 6 7 8 9 
  3    T F F T F F F F F F
  34   T F F T F F F F F F      - 3 & 34 form this sum , @ pos4 , yes 3 alone form 3
  4    T F F T T F F T F F    - before 4 , whatever it came from top, @ 4 , yes it can form 4 from 4, after 4 ,, got prev val or 4 stpes backward check see val
  12   T F F T T F F T F F
  5    T F F T T T F F T T   - can we still break at the end of here ?
  2    T F T T T T T T T T 
	 */
	
	static boolean isSubsetPossible(int[] nums, int sum) {	
		boolean[][] dp = new boolean[nums.length][sum + 1];
		for(int row = 0; row < dp.length; row++) {
			dp[row][0] = true;
		}
 
		for(int row = 0; row < dp.length; row++) {
			int num = nums[row];
			for(int col = 1; col < dp[0].length; col++) {
				if( col < num ) {
					dp[row][col] = (row == 0) ? false : dp[row - 1][col];
				}else if(num == col) {
					dp[row][col] = true;
				}else {
					dp[row][col] = dp[row - 1][col] || dp[row - 1][col - num];
				}
			}
			if(dp[row][sum]){
				System.out.println("breaked at row " + row);
				return true;
			}
		}
		System.out.println("all the way end");
		return dp[nums.length - 1][sum];
	}
	
	public static void main(String[] args) {
		int[] nums = {9, 3, 34, 4, 12, 5, 2};
		int sum = 9;
		System.out.println(isSubsetPossible(nums, sum));

	}
}
