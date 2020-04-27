import java.util.*;
import java.io.*;

// 정글은 J, 바다는 O, 얼음은 I

public class 행성탐사_5549 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		char[][] map = new char[N + 1][M + 1];
		int[][][] dp = new int[N + 1][M + 1][3];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1);
				for (int k = 0; k < 3; k++)
					dp[i][j][k] = dp[i - 1][j][k] + dp[i][j - 1][k] - dp[i - 1][j - 1][k];
				if (map[i][j] == 'J')
					dp[i][j][0] += 1;
				else if (map[i][j] == 'O')
					dp[i][j][1] += 1;
				else if (map[i][j] == 'I')
					dp[i][j][2] += 1;
			}
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 3; i++)
				bw.write((dp[c][d][i] - dp[c][b - 1][i] - dp[a - 1][d][i] + dp[a - 1][b - 1][i]) + " ");
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}

}
