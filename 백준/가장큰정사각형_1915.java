import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 가장큰정사각형_1915 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[][] dp = new int[n + 1][m + 1];
		int k = 0;
		for (int i = 1; i <= n; i++) {
			s = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				dp[i][j + 1] = Integer.parseInt(s[j]);
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i][j] == 0)
					continue;
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				if (dp[i][j] > k)
					k = dp[i][j];
			}
		}
		System.out.println(k * k);
		br.close();

	}

}
