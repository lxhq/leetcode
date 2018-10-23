public class climbStairs {
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  public static void main(String[] stra){
    climbStairs a = new climbStairs();
    System.out.println(a.climbStairs(100));
  }
}
