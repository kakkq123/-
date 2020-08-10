import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
	static int INF = 10000000;
	static int[] d = new int[4002];
	static ArrayList<Pos>[] a;

	static class Pos implements Comparable<Pos> {
		int s, e;

		public Pos(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Pos p) {
			return this.e < p.e ? -1 : 1;
		}
	}

	public static int getDistance(Pos p1, Pos p2) {
		return (int) Math.sqrt((p1.s - p2.s) * (p1.s - p2.s) + (p1.e - p2.e) * (p1.e - p2.e));
	}
  
  //BFS로 푸는 것보다 속도가 약 2배 정도 빠르다
	public static int dijkstra() {
		d[0] = 0;
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		q.add(new Pos(0, 0));
		while (!q.isEmpty()) {
			int cur = q.peek().s, dis = q.peek().e;
			q.poll();
			if (cur == 1) {
				return dis;
			}
			if (d[cur] > dis)
				continue;
			for (Pos p : a[cur]) {
				int next = p.s, nextDis = dis + p.e;
				if (d[next] > nextDis) {
					d[next] = nextDis;
					q.add(new Pos(next, nextDis));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Pos> t = new ArrayList<Pos>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
				x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
		t.add(new Pos(x1, y1));
		t.add(new Pos(x2, y2));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			t.add(new Pos(x, y));
		}
		br.close();
		a = new ArrayList[n + 2];
		for (int i = 0; i < n + 2; i++) {
			d[i] = INF;
			a[i] = new ArrayList<Pos>();
		}
		// 소수
		boolean[] prime = new boolean[8501];
		int sqrt = (int) Math.sqrt(8501);
		for (int i = 2; i <= sqrt; i++) {
			if (prime[i])
				continue;
			for (int j = i + i; j <= 8500; j += i)
				prime[j] = true;
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = i + 1; j < n + 2; j++) {
				int dis = getDistance(t.get(i), t.get(j));
				if (!prime[dis]) {
					a[i].add(new Pos(j, dis));
					a[j].add(new Pos(i, dis));
				}
			}
		}
		dijkstra();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		d[1] = d[1] == INF ? -1 : d[1];
		bw.write(d[1] + "\n");
		bw.flush();
		bw.close();
	}

}
