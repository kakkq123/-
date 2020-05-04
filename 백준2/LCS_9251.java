import java.io.*;

public class LCS_9251 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		int[][] dp = new int[a.length() + 1][b.length() + 1];
		
		for (int i = 1; i <= a.length(); i++) {
			char _a = a.charAt(i - 1);
			for (int j = 1; j <= b.length(); j++) {
				char _b = b.charAt(j - 1);
				if (_a == _b)
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				
			}
		}
		System.out.println(dp[a.length()][b.length()]);
		br.close();
	}

}
