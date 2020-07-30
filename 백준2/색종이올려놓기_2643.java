import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n + 1][2];

		a[0][0] = a[0][1] = 1000;
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x >= y) {
				a[i][0] = x;
				a[i][1] = y;
			} else {
				a[i][0] = y;
				a[i][1] = x;
			}
		}
		// 내림차순으로 정렬
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o2[1] - o1[1];
				return  o2[0] - o1[0];
			}
		});

		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {

			for (int j = 0; j < i; j++) {
				if (a[i][0] <= a[j][0] && a[i][1] <= a[j][1] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}

		}
		// 최댓값 찾기
		int answer = 0;
		for (int i = 1; i <= n; i++)
			answer = Math.max(answer, dp[i]);

		bw.write(answer + "\n");
		br.close();
		bw.close();
	}

}
