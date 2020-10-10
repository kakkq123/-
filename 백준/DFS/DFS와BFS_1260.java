import java.util.*;
import java.io.*;

public class DFS¿ÍBFS_1260 {
	static int N;
	static boolean[][] a;
	static Queue<Integer> bfs_store = new LinkedList<Integer>();
	static Queue<Integer> dfs_store = new LinkedList<Integer>();

	public static void dfs(int cur, boolean[] v) {
		for (int i = 1; i <= N; i++) {
			if (a[cur][i] && !v[i]) {
				v[i] = true;
				dfs_store.add(i);
				dfs(i, v);
			}
		}
	}

	public static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		boolean[] visit = new boolean[N + 1];
		visit[V] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			bfs_store.add(cur);
			for (int i = 1; i <= N; i++) {
				if (a[cur][i] && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		a = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			a[s][d] = a[d][s] = true;
		}
		br.close();
		
		dfs_store.add(V);
		boolean[] v = new boolean[N + 1];
		v[V] = true;
		dfs(V, v);
		bfs(V);
		while (!dfs_store.isEmpty()) {
			int num = dfs_store.poll();
			bw.write(num+" ");
		}
		bw.write("\n");
		while (!bfs_store.isEmpty()) {
			int num = bfs_store.poll();
			bw.write(num+" ");
		}
		bw.close();
	}

}
