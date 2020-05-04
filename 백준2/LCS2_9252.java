import java.io.*;

public class LCS2_9252 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String a = br.readLine();
		String b = br.readLine();
		int[][] dp = new int[1001][1001];
		int[][] s = new int[1001][1001];

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					s[i][j] = 1;
				} else {
					if (dp[i - 1][j] > dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
						s[i][j] = 2;
					} else {
						dp[i][j] = dp[i][j - 1];
						s[i][j] = 3;
					}

				}
			}
		}
		int i = a.length(), j = b.length();
		StringBuilder sb = new StringBuilder();
		while (s[i][j] > 0) {
			if (s[i][j] == 1) {
				sb.append(a.charAt(i - 1));
				i--;
				j--;
			} else if (s[i][j] == 2)
				i--;
			else if (s[i][j] == 3)
				j--;
		}
		bw.write(dp[a.length()][b.length()] + "\n");
		if (dp[a.length()][b.length()] > 0) {
			bw.write(sb.reverse().toString() + "\n");
		}
		br.close();
		bw.close();

	}

}
