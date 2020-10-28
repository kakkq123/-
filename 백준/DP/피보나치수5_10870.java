import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			if (i == 1)
				dp[1] = 1;
			else
				dp[i] = dp[i - 1] + dp[i - 2];
		}
		bw.write(dp[N] + "\n");
		bw.close();
	}

}
