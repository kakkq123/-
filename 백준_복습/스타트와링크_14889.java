import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static int[][] a = new int[21][21];
	static boolean[] team = new boolean[21];

	public static void dfs(int idx, int num) {
		if (num == N / 2) {
			int sum_1 = 0, sum_2 = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(team[i] && team[j])
						sum_1 += a[i][j];
					if(!team[i] && !team[j])
						sum_2 += a[i][j];
				}
			}
			min = Math.min(min, Math.abs(sum_1 - sum_2));
			return;
		}
		if (idx >= N)
			return;

		team[idx] = true;
		dfs(idx + 1, num + 1);
		team[idx] = false;
		dfs(idx + 1, num);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				a[i][j] = Integer.parseInt(st.nextToken());

		}
		dfs(1, 0);
		System.out.println(min);

		br.close();
	}

}
