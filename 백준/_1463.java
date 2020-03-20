import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			//1을 빼는 경우
			dp[i] = dp[i - 1] + 1;
			//3과 2의 최소공배수 6을 생각해줘야함
			if (i % 6 == 0)
				dp[i] = Math.min(Math.min(dp[i], dp[i / 2] + 1), Math.min(dp[i], dp[i / 3] + 1));
			//2로만 나눌 수 있는 경우
			else if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			//3으로 나눌 수 있는 경우
			else if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}
		System.out.printf("%d", dp[n]);
	}

}
