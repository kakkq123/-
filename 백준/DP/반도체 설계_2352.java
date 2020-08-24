import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n], dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j >= 0; j--)
				if (a[i] > a[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
		}

		int max = 0;
		for (int i = 0; i < n; i++)
			max = Math.max(max, dp[i]);
		bw.write(max + "\n");
		br.close();
		bw.close();
	}

}
