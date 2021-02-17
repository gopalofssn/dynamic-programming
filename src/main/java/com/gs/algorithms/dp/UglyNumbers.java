package dynamic.programming;

import java.util.Arrays;

public class UglyNumbers {

  public int nthUglyNumber(int n) {
    int result = 0;
    while (n > 0) {
      result = findNextUglyNumber(result);
      System.err.println(result);
      n--;
    }

    return result;
  }

  private int findNextUglyNumber(int num) {
    while (true) {
      num = num + 1;
      if (isUgly(num)) {
        return num;
      }
    }
  }

  private boolean isUgly(int num) {
    if (num == 1) {
      return true;
    }

    num = maxDivide(num, 2);
    num = maxDivide(num, 3);
    num = maxDivide(num, 5);
    /*
     * try { Thread.sleep(100); } catch (InterruptedException e) { // TODO Auto-generated catch
     * block e.printStackTrace(); }
     */
    return (num == 1);
  }

  private int maxDivide(int num, int divisor) {
    while (num % divisor == 0) {
      num = num / divisor;
    }

    return num;
  }

 public static void main(String[] args) {
	  for(int i = 3; i <= Math.ceil(Math.sqrt(14)); i+=2) {
	      System.err.println(i);
	    }
}

  private static void increase(Integer i) {
    i++;
    
    System.err.println(i);
    
  }

  /*
   * (2) , 1X2,2X2,3X2,4X2,5X2,6X2,7X2 (3) , 1X3,2X3,3X3,4X3,5X3... (5) , 1X5,2X5,3X5,4X5,,,
   */
  private int nthUglyNumberDP(int n) {

    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    int index2 = 0;
    int index3 = 0;
    int index5 = 0;

    int[] dp = new int[n];
    dp[0] = 1;
 

    for (int i = 1; i < n; i++) {

      int min = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
      dp[i] = min;
System.err.println(Arrays.toString(dp));
      if (min == dp[index2] * 2) {
        index2++;
      }

      if (min == dp[index3] * 3) {
        index3++;
      }

      if (min == dp[index5] * 5) {
        index5++;
      }
    }

    return dp[n - 1];
  }

}
