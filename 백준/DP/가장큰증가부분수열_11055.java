import java.io.*;
import java.util.*;

public class Main {

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		br.close();
		int max = 0;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = a[i];
			for (int j = 0; j < i; j++) 
				if (a[j] < a[i] && dp[j] + a[i] > dp[i])
					dp[i] = dp[j] + a[i];
			max = Math.max(dp[i], max);
		}
		bw.write(max + "\n");
		bw.close();
	}

}
