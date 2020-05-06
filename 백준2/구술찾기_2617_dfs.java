import java.io.*;
import java.util.*;

public class 구술찾기_2617_dfs {
	static int N, cnt, rcnt;
	static boolean[][] a = new boolean[100][100];
	static boolean[] visit;

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
			// 초기화
			cnt = 0;
			rcnt = 0;
			
			visit = new boolean[N + 1];
			visit[i] = true;
			dfs(i);
			
			visit = new boolean[N + 1];
			visit[i] = true;
			reverse_dfs(i);
			
			// 중간이 아닌가?
			if (cnt >= mid || rcnt >= mid)
				result++;
		}
		br.close();
		bw.write(result + "\n");
		bw.close();
	}

	private static void reverse_dfs(int node) {
		for (int i = 1; i <= N; i++) {
			if (a[i][node] && !visit[i]) {
				visit[i] = true;
				rcnt++;
				reverse_dfs(i);
			}
		}
	}

	private static void dfs(int node) {
		for (int i = 1; i <= N; i++) {
			if (a[node][i] && !visit[i]) {
				visit[i] = true;
				cnt++;
				dfs(i);
			}
		}
	}

}
