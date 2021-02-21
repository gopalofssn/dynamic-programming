package com.gs.algorithms.dp;

import java.util.Arrays;

public class IsSubsequence {

	/*
		    a h b g d c
		  T F F F F F F
		a F T T T T T t
		b F f f t t t t
		c F f f f f f t   
	*/
	public boolean isSubsequence(String s, String t) {
	   if(isNullOrEmpty(s)) return true;
	   if(isNullOrEmpty(t)) return false;
	   final int sLEN = s.length();
	   final int tLEN = t.length();
	   boolean[][] dp = new boolean[ sLEN + 1][tLEN + 1];
	   dp[0][0] = true;
	   for(int row = 1; row <= sLEN; row++ ){
	       for(int col = 1; col <= tLEN; col++){
	           char sChar = s.charAt(row - 1);
	           char tChar = t.charAt(col -1);
	           if(sChar == tChar){
	               dp[row][col] = dp[row -1][col -1];
	           }else{
	              dp[row][col] = dp[row][col - 1]; 
	           }
	       }
	   }
	   System.out.println(Arrays.deepToString(dp));
	   return dp[sLEN][tLEN];
	}
	
	private boolean isNullOrEmpty(String str){
	   return (str == null || str.isEmpty());
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println(new IsSubsequence().isSubsequence(s, t));

	}

}
