import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10844 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[][] dp = new long[n + 1][10];

		for (int i = 1; i <= 9; i++)
			dp[1][i] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0)
					dp[i][0] = dp[i - 1][1] % 1000000000;
				else if (j == 9)
					dp[i][9] = dp[i - 1][8] % 1000000000;
				else
					dp[i][j] = dp[i - 1][j - 1] % 1000000000 + dp[i - 1][j + 1] % 1000000000;

			}
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++)
			sum = (sum + dp[n][i]) % 1000000000;
		System.out.println(sum % 1000000000);
		br.close();
	}

}
