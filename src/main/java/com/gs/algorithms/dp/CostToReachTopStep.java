package com.gs.algorithms.dp;

import java.util.Arrays;

public class CostToReachTopStep {

	private static int minimumCost(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		final int LEN = nums.length;
		System.out.println("ORG " + Arrays.toString(nums));
		int[] dp = new int[LEN];
		dp[0] = nums[0];
		dp[1] = nums[1];
		for(int i = 2; i < LEN; i++){
			dp[i] = nums[i] + Math.min(dp[i - 2], dp[i - 1]);
		}
		System.out.println("DP  " + Arrays.toString(dp));
		return Math.min(dp[LEN - 2], dp[LEN - 1]);
	}

	public static void main(String[] args) {
		int[] nums = {16, 19, 10, 12, 18};
		System.out.println(minimumCost(nums));
	}
	
}
