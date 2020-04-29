import java.util.*;
import java.io.*;

public class 다이아몬드광산_1028 {

	public static void main(String[] args) throws Exception {
		int R, C, max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[R + 2][C + 2][2];
		for (int i = 1; i <= R; i++) {
			String s = br.readLine();
			for (int j = 1; j <= C; j++) {
				dp[i][j][0] = dp[i][j][1] = s.charAt(j - 1) - '0';
				if (dp[i][j][0] == 1) {
					dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
					dp[i][j][1] = dp[i - 1][j + 1][1] + 1;
				}
			}
		}
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (dp[i][j][0] > 0) {
					for (int t = dp[i][j][0] - 1; t >= max; t--)
						if (i - t >= 1 && j - t >= 1 && j + t <= C) {
							if (dp[i][j][1] >= t + 1 && dp[i - t][j - t][1] >= t + 1 && dp[i - t][j + t][0] >= t + 1)
								max = t + 1;
						}
				}
			}
		}
		br.close();
		System.out.println(max);
	}

}
