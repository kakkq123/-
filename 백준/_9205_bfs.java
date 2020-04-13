import java.util.*;
import java.io.*;

public class _9205_bfs {
	static int N, INF = 2000000;
	static int[] d;

	public static void bfs(int[][] a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		boolean[][] visit = new boolean[N + 2][N + 2];
		d = new int[N + 2];
		d[0] = 1;
		Arrays.fill(d, INF);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == N + 1)
				return;
			for (int i = 1; i < N + 2; i++) {
				if (visit[cur][i] || cur == i)
					continue;
				visit[cur][i] = true;
				int dis = Math.abs(a[cur][0] - a[i][0]) + Math.abs(a[cur][1] - a[i][1]);
				float bottle = (float) dis / 50;
				if (bottle <= 20) {
					q.add(i);
					d[i] = 1;
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] a = new int[N + 2][2];
			st = new StringTokenizer(br.readLine());
			a[0][0] = Integer.parseInt(st.nextToken());
			a[0][1] = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				a[i][0] = Integer.parseInt(st.nextToken());
				a[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			a[N + 1][0] = Integer.parseInt(st.nextToken());
			a[N + 1][1] = Integer.parseInt(st.nextToken());

			bfs(a);
			
			if (d[N + 1] < INF)
				bw.append("happy\n");
			else
				bw.append("sad\n");
		}
		br.close();
		bw.close();
	}

}
