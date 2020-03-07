import java.io.*;
import java.util.*;

public class 거의최단경로_5719 {
	static int[] d;
	static int[][] a;
	static int N, s, e, INF = 10000;
	static ArrayList<Integer>[] record;

	static class Pos {
		int next, dis;

		public Pos(int next, int dis) {
			this.next = next;
			this.dis = dis;
		}
	}

	public static void dijkstra() {
		// 모든 최단경로를 구하기 때문에 굳이 우선순위큐를 사용하지 않음
		// 우선순위큐를 사용하는 것보다 메로리, 시간 효율성이 좋음
		d[s] = 0;
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(s, 0));
		while (!q.isEmpty()) {
			int cur = q.peek().next, dis = q.peek().dis;
			q.poll();
			if (d[cur] > dis)
				continue;
			for (int i = 0; i < N; i++) {
				if (a[cur][i] == INF) {
					continue;
				}
				int nextDis = dis + a[cur][i];
				// >= 부등호 중요하다! > 사용하면 중복되는 최단 거리 경로를 저장하지 못하기 때문이다
				if (d[i] >= nextDis) {
					d[i] = nextDis;
					q.add(new Pos(i, nextDis));
					record[i].add(cur); // 경로 저장
				}
			}
		}
	}

	//dfs로 최단경로들을 삭제하였는데 bfs로 최단경로를 삭제하는 것이 훨씬 효율적이다
	public static void erase(int cur) {
		// 목적지로부터 역으로 최단 경로를 끊어준다
		for (int pre : record[cur]) {
			if (d[pre] == INF || d[cur] != d[pre] + a[pre][cur])
				continue;
			a[pre][cur] = INF; // 경로를 끊어줌
			erase(pre);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) {
				break;
			}
			//
			record = new ArrayList[N]; // 이동한 경로들을 저장
			d = new int[N]; // 최단경로 저장을 위한 배열
			a = new int[N][N]; // 각 노드간의 거리를 저장
			for (int i = 0; i < N; i++) {
				Arrays.fill(a[i], INF);
				d[i] = INF;
				record[i] = new ArrayList<Integer>();
			}

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			//
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken()),
						p = Integer.parseInt(st.nextToken());
				a[u][v] = p;
			}

			dijkstra();
			erase(e); // 최단경로 삭제
			for (int i = 0; i < N; i++)
				d[i] = INF;
			dijkstra();
			int result = d[e] == INF ? -1 : d[e];
			bw.write(result + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
