public class IsMatch {

  public boolean isMatch(String s, String p) {
    if (s == null || p == null) return false;
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

    dp[0][0] = true;

    for (int i = 1; i < dp[0].length; i++) {
      if (p.charAt(i - 1) == '*' && i > 1) {
        dp[0][i] = dp[0][i - 2];
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) =='.') {
          dp[i][j] = dp[i - 1][j - 1];
        }
        if (p.charAt(j - 1) == '*' && j > 1) {
          if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
            dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
          } else {
            dp[i][j] = dp[i][j - 2];
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }

  public static void main(String[] args) {
    IsMatch a = new IsMatch();
    System.out.println(a.isMatch("ab", ".*"));
    //System.out.println(a.isMatch("aab", "c*a*b"));
    //System.out.println(a.isMatch("aab","abd"));
    //System.out.println(a.isMatch("mississippi","mis*is*p*."));
  }

  private void print(boolean[][] dp) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println('\n');
    }
    System.out.println('\n');
  }
}
