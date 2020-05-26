import java.util.Scanner;

public class maze {
 public static void main(String[] args) {
  Scanner kb = new Scanner(System.in);
  int n = kb.nextInt();
  int m = kb.nextInt();

  int[][] maze = new int[n+1][m+1];
  int[][] dp = new int[n+1][m+1];

  for (int i = 1; i <= n; i++)
   for (int j = 1; j <= m; j++) {
    maze[i][j] = kb.nextInt();
    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + maze[i][j];
   }



  System.out.printf("%d",dp[n][m]);
 }

}









