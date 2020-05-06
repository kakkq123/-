import java.io.*;
import java.util.*;

public class 구슬찾기_2617_bfs {
	static int N, cnt, rcnt;
	static boolean[][] a = new boolean[100][100];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()), mid = (N + 1) / 2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			a[y][x] = true;
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			cnt = bfs(i);
			rcnt = reverse_bfs(i);
			if (cnt >= mid || rcnt >= mid)
				result++;
		}
		br.close();
		bw.write(result + "\n");
		bw.close();
	}

	private static int reverse_bfs(int start) {
		boolean[] visit = new boolean[100];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i = 1; i <= N; i++) {
				if (a[i][node] && !visit[i]) {
					visit[i] = true;
					cnt++;
					q.add(i);
				}
			}
		}
		return cnt;
	}

	private static int bfs(int start) {
		boolean[] visit = new boolean[100];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i = 1; i <= N; i++) {
				if (a[node][i] && !visit[i]) {
					visit[i] = true;
					cnt++;
					q.add(i);
				}
			}
		}
		return cnt;
	}

}
