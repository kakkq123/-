import java.io.*;

public class 오르막수_11057 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		for (int i = 1; i < 10; i++)
			dp[1][i] = 1;
		int count = 10;
		for (int len = 2; len <= N; len++) {
			dp[len][1] = 1;
			count++;
			for (int i = 2; i < 10; i++) {
				dp[len][i] = (dp[len - 1][i] + dp[len][i - 1]) % 10007;
				count += dp[len][i];
				count %= 10007;
			}
		}
		System.out.println(count);
	}

}
