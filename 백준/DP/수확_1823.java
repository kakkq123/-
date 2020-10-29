import java.io.*;

public class Main2 {
	static int N;
	static int[] v = new int[2001];
	static int[][] dp = new int[2001][2001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++)
			v[i] = Integer.parseInt(br.readLine());
		
		harvest(1, N, 1);
		bw.write(dp[1][N] + "\n");
		bw.close();
	}

	private static int harvest(int s, int e, int k) {
		//k번째 수확일 경우
		if (k == N)
			return dp[s][e] = v[s] * k;

		//이미 존재하는 값이면
		if (dp[s][e] > 0)
			return dp[s][e];

		//왼쪽 먼저 수확
		int tmp_1 = v[s] * k + harvest(s + 1, e, k + 1);
		//오른쪽 먼저 수확
		int tmp_2 = v[e] * k + harvest(s, e - 1, k + 1);

		if (tmp_1 > tmp_2)
			return dp[s][e] = tmp_1;
		return dp[s][e] = tmp_2;
	}
}
