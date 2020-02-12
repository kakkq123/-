import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2156 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		int[] wine = new int[n + 1];
		for (int i = 1; i <= n; i++)
			wine[i] = Integer.parseInt(br.readLine());
		dp[1] = wine[1];
		for (int i = 2; i <= n; i++) {
			if (i == 2)
				dp[2] = wine[1] + wine[2];
			else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]));
			}
		}
		System.out.println(dp[n]);
		br.close();

	}

}
