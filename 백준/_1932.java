import java.util.Scanner;

public class _1932 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] dp = new int[501][501];
		int[][] triangle = new int[501][501];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i + 1; j++)
				triangle[i][j] = kb.nextInt();
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1) {
					dp[i][j] = triangle[i][j] + dp[i - 1][j];
				} else
					dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				// ÃÖ´ñ°ªº¸´Ù Å©¸é max°ª º¯°æ
				if (dp[i][j] > max)
					max = dp[i][j];
			}
		}
		System.out.println(max);

	}

}
