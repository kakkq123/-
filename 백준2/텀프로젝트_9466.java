import java.util.*;
import java.io.*;

public class 텀프로젝트_9466 {
	static int n, cnt;
	static int[] a, cycle; // cycle : 사이클 구분하는 번호
	static boolean[] v; //방문처리

	//cnt를 전체 학생 수로 초기화해주고 사이클 생긴 노드 개수를 삭제함
	public static void link(int node) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a[node]);

		while (!q.isEmpty()) {
			int cur = q.poll();
			cnt--; // *****
			if (cur == node) {
				break;
			}
			q.add(a[cur]);
		}
	}

	public static void bfs(int start, int number) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a[start]);
		v[start] = true;
		cycle[start] = number;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == start) {
				link(cur);
				break;
			}
			//재방문
			if (v[cur]) {
				//같은 그래프에 있는 노드에 재방문
				if (cycle[cur] == number) {
					link(cur);
				}
				break;
			}
			cycle[cur] = number;
			v[cur] = true;
			q.add(a[cur]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int test = 0; test < t; test++) {
			n = Integer.parseInt(br.readLine());
			cnt = n;
			a = new int[n + 1];
			cycle = new int[n + 1];
			v = new boolean[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++)
				a[i] = Integer.parseInt(st.nextToken());

			int number = 0;
			for (int i = 1; i <= n; i++)
				if (!v[i])
					bfs(i, ++number);

			bw.write(cnt + "\n");
			bw.flush();
		}
		br.close();
		bw.close();

	}

}
