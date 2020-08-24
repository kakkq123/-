import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
	static int n, m, x, INF = 2000000;
	static int[] d1, d2;
	static int[][] a;

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		// 간선을 저장할 배열
		a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			Arrays.fill(a[i], INF);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()),
					T = Integer.parseInt(st.nextToken());
			a[A][B] = Math.min(a[A][B], T);
		}
		go(); // x로 파티갈 때 최소거리
		back(); // 귀가할 때 최소거리
		int max = 0;
		for (int i = 1; i <= n; i++)
			max = Math.max(max, d1[i] + d2[i]);
		bw.write(max + "\n");
		br.close();
		bw.close();

	}

	private static void back() {
		//출발은 x
		//일반적 다익스트라 알고리즘처럼 각 노드의 최소거리를 구한다
		d2 = new int[n + 1];
		Arrays.fill(d2, INF);
		d2[x] = 0;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, 0));

		while (!q.isEmpty()) {
			int cur = q.peek().x, time = q.peek().y;
			q.poll();
			if (d2[cur] > time)
				continue;
			for (int next = 1; next <= n; next++) {
				if (d2[next] > time + a[cur][next]) {
					d2[next] = time + a[cur][next];
					q.add(new Point(next, d2[next]));
				}
			}
		}

	}

	public static void go() {
		//반대로 생각한다! x가 도착점이다
		d1 = new int[n + 1];
		Arrays.fill(d1, INF);
		d1[x] = 0;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, 0));

		while (!q.isEmpty()) {
			int cur = q.peek().x, time = q.peek().y;
			q.poll();
			if (d1[cur] > time)
				continue;
			for (int previous = 1; previous <= n; previous++) {
				if (d1[previous] > time + a[previous][cur]) {
					d1[previous] = time + a[previous][cur];
					q.add(new Point(previous, d1[previous]));
				}
			}
		}
	}

}
