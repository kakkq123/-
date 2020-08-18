import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> a[]; // 이어진 간선을 저장
	static int[] color; // 색상 저장
	static boolean Bipartite; // 이분그래프인가?

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		for (int test = 0; test < k; test++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			a = new ArrayList[v + 1];
			for (int i = 1; i <= v; i++)
				a[i] = new ArrayList<Integer>();

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				a[start].add(end);
				a[end].add(start);
			}

			color = new int[v + 1]; // 색미지정: 0, 색: -1, 1
			Bipartite = true;

			// 이분그래프인지 확인
			for (int i = 1; i <= v && Bipartite; i++) {
				if (color[i] == 0) {
					color[i] = 1;
					dfs(i);
				}
			}
			// 출력
			if (Bipartite)
				bw.write("YES\n");
			else
				bw.write("NO\n");

		}
		br.close();
		bw.close();

	}

	private static void dfs(int cur) {
		if (!Bipartite)
			return;
		for (int next : a[cur]) {
			if(color[next]==color[cur]) {
				Bipartite = false;
				return;
			}
			if(color[next] == 0) {
				color[next] = -color[cur];
				dfs(next);
			}
		}
	}
}
