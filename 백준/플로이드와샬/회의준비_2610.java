import java.io.*;
import java.util.*;

public class Main {
	static int[][] a;
	static int N, INF = 2000000;

	static class Info implements Comparable<Info> {
		int cur, max;

		public Info(int cur, int max) {
			this.cur = cur;
			this.max = max;
		}

		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			if (this.max == o.max)
				return this.cur - o.cur;
			return this.max - o.max;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		a = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(a[i], INF);
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			a[s][d] = a[d][s] = 1;
		}
		floyd();

		int cnt = 0;
		boolean[] visit = new boolean[N + 1];
		ArrayList<Integer> answer = new ArrayList<Integer>();
		while (cnt < N) {
			for (int i = 1; i <= N; i++) {
				if (visit[i])
					continue;
				ArrayList<Integer> t = new ArrayList<Integer>();
				for (int j = 1; j <= N; j++) {
					if (a[i][j] != INF) {
						t.add(j);
						visit[j] = true;
						cnt++;
					}
				}
				//
				PriorityQueue<Info> q = new PriorityQueue<Info>();
				for (int next : t) {
					int max = 0;
					for (int j = 1; j <= N; j++) {
						if (a[next][j] != INF) {
							max = Math.max(max, a[next][j]);
						}
					}
					q.add(new Info(next, max));
				}
				answer.add(q.peek().cur);
			}
		}
		Collections.sort(answer);
		bw.write(answer.size() + "\n");
		for (int ans : answer)
			bw.write(ans + "\n");
		br.close();
		bw.close();
	}


	private static void floyd() {
		for (int k = 1; k <= N; k++) {
			for (int s = 1; s <= N; s++) {
				for (int d = 1; d <= N; d++) {
					if (s == d) {
						a[s][d] = 0;
						continue;
					}
					if (a[s][d] > a[s][k] + a[k][d])
						a[s][d] = a[s][k] + a[k][d];
				}
			}
		}
	}
}
