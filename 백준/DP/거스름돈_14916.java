import java.io.*;
import java.util.*;

//거스름돈_14916
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		final int MAX = 100001;
		int[] dp = new int[MAX];
		dp[0] = 0;
		dp[1] = dp[3] = MAX;
		dp[2] = 1;
		dp[4] = 2;
		for (int i = 5; i <= n; i++) {
			dp[i] = Math.min(1 + dp[i - 2], 1 + dp[i - 5]);
		}
		if(dp[n] == MAX)
			bw.write("-1");
		else
			bw.write((dp[n]) + "");
		bw.close();
	}
}
