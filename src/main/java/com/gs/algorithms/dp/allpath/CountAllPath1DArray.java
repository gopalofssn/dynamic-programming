package com.gs.algorithms.dp.allpath;

/**
 Condition : only can travel right (->) or down 
    SRC : 0, 0
    Dest : n,n
    
    let us take 4X4 matrix
    
    1 1 1 1
    1 2 3 4
    1 3 6 10
    1 4 10 20
    
    Time : O(n) , n = r*c
    Space : O(c)
 **/

public class CountAllPath1DArray {

  public int totalPath(int[][] grid) {
    if(grid == null || grid.length == 0) {
      return 0;
    }
    
    int totalRows = grid.length;
    int totalColumns = grid[0].length;
    int[] dp = new int[totalColumns];
    
    for(int col = 0; col < totalColumns; col++) {
      dp[col] = 1;
    }
    
    for(int row = 1; row < totalRows; row++) {
      for(int col = 1; col < totalColumns; col++) {
        dp[col] = dp[col] + dp[col -1];
      }
    }
    
    return dp[totalColumns -1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 2, 3, 1}, {4, 5, 6, 1}, {7, 8, 9, 1}, {1,1,1,1}};
    System.out.println(new CountAllPath1DArray().totalPath(grid));
  }
}
