package com.gs.algorithms.dp.allpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AllPathFinderUsingDP {

  /*
   *   1   2  
   *   3   4   
   * 
   *   {{1}}       {{1,2}}
   *   {{1, 3}}    {{1,2,4},{1,3,4}}
   *   
   *   
   *   Time : O(n)
   *   Space : O(2^n) ? 
   */
  public List<List<Integer>> findAllPath(int[][] grid) {

    final int ROWS = grid.length;
    final int COLS = grid[0].length;
    List<List<Integer>>[][] dp = new List[10][10];

    List<List<Integer>> prevLeft = new ArrayList<List<Integer>>();
    prevLeft.add(new ArrayList<Integer>());
    for (int col = 0; col < COLS; col++) {
      dp[0][col] = new ArrayList<List<Integer>>();
      addPrev(dp[0][col], prevLeft, grid[0][col]);
      prevLeft = dp[0][col];
    }

    List<List<Integer>> prevTop = new ArrayList<List<Integer>>();
    prevTop.add(new ArrayList<Integer>());
    for (int row = 0; row < ROWS; row++) {
      dp[row][0] = new ArrayList<List<Integer>>();
      addPrev(dp[row][0], prevTop, grid[row][0]);
      prevTop = dp[row][0];
    }

    for (int row = 1; row < ROWS; row++) {
      for (int col = 1; col < COLS; col++) {
        dp[row][col] = new ArrayList<List<Integer>>();

        prevLeft = dp[row][col - 1];
        addPrev(dp[row][col], prevLeft, grid[row][col]);

        prevTop = dp[row - 1][col];
        addPrev(dp[row][col], prevTop, grid[row][col]);
      }
    }

    return dp[ROWS - 1][COLS - 1];
  }

  private void addPrev(List<List<Integer>> current, List<List<Integer>> prev, int val) {
    for (List<Integer> lst : prev) {
      List<Integer> plusOne = new ArrayList<Integer>(lst);
      plusOne.add(val);
      current.add(plusOne);
    }
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<List<Integer>> allPathFinder = new AllPathFinderUsingDP().findAllPath(grid);
    System.out.println("Total possible path " + allPathFinder.size());
    for (List<Integer> list : allPathFinder) {
      System.out.println(list);
    }
  }


}
