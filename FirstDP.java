import java.util.LinkedList;
import java.util.Queue;

public class FirstDP {
  public boolean dpSubset(int[] arr, int des) {
    boolean [][] dp = new boolean[arr.length][des + 1];

    for (int i = 0; i < dp[0].length; i++) {
      dp[0][i] = false;
    }
    dp[0][3] = true;

    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (arr[i] > j) {
          dp[i][j] =  dp[i - 1][j];
        } else {
          boolean a = dp[i - 1][j];
          boolean b = dp[i - 1][j - arr[i]];
          dp[i][j] = a || b;
        }

      }
    }
    return dp[arr.length - 1][des];
  }

  public static void main(String[] args) {
    FirstDP a = new FirstDP();
    int[] arr = {3, 34, 4, 12, 5, 2};
    System.out.println(a.dpSubset(arr, 9));
    System.out.println(a.dpSubset(arr, 10));
    System.out.println(a.dpSubset(arr, 11));
    System.out.println(a.dpSubset(arr, 12));
    System.out.println(a.dpSubset(arr, 13));

    String b = "abcdefg";
    System.out.println(b.substring(0, 7));
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(null);
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    b = b + null;
    System.out.println(b.charAt(8));
  }
}
