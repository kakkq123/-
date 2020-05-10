import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCS3_1958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		int[][][] dp = new int[101][101][101];
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				for (int k = 1; k <= c.length(); k++) {
					if (a.charAt(i - 1) == b.charAt(j - 1) && b.charAt(j - 1) == c.charAt(k - 1))
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					else
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));

				}
			}
		}
		System.out.println(dp[a.length()][b.length()][c.length()]);
	}

}
