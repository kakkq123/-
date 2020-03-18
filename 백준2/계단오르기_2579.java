import java.io.*;

public class 계단오르기_2579 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n + 1], dp = new int[n + 1];
		for (int i = 1; i <= n; i++)
			a[i] = Integer.parseInt(br.readLine());
		br.close();
		
		dp[1] = a[1];
		for (int i = 2; i <= n; i++) {
			if (i == 2)
				dp[2] = a[1] + a[2];
			else {
				dp[i] = Math.max(dp[i - 3] + a[i - 1] + a[i], dp[i - 2] + a[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
