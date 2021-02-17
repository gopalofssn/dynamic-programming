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
    
    Time : O(n)
    Space : O(n)
 **/

public class CountAllPath2DArray {

  public int totalPath(int[][] grid) {
    if(grid == null || grid.length == 0) {
      return 0;
    }
    
    int totalRows = grid.length;
    int totalColumns = grid[0].length;
    int[][] dp = new int[totalRows][totalColumns];
    
    for(int col = 0; col < totalColumns; col++) {
      dp[0][col] = 1;
    }
    
    for(int row = 0; row < totalRows; row++) {
      dp[row][0] = 1;
    }
    
    for(int row = 1; row < totalRows; row++) {
      for(int col = 1; col < totalColumns; col++) {
        dp[row][col] = dp[row -1][col] + dp[row][col -1];
      }
    }
    
    return dp[totalRows -1][totalColumns -1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(new CountAllPath2DArray().totalPath(grid));
  }
}
