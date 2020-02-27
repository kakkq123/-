import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class 소수마을_14431 {
	static int INF = 10000000;
	static int[] d = new int[4002];
	static ArrayList<Pos>[] a;
	static ArrayList<Pos> t = new ArrayList<Pos>();

	static class Pos {
		int s, e;

		public Pos(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

	public static int getDistance(Pos p1, Pos p2) {
		return (int) Math.sqrt((p1.s - p2.s) * (p1.s - p2.s) + (p1.e - p2.e) * (p1.e - p2.e));
	}

	public static void bfs() {
		d[0] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		while (!q.isEmpty()) {
			int index = q.poll();
			for (Pos p : a[index]) {
				int next = p.s, dis = p.e;
				if (d[index] != INF && d[next] > d[index] + dis) {
					d[next] = d[index] + dis;
					q.add(next);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		bfs();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		d[1] = d[1] == INF ? -1 : d[1];
		bw.write(d[1] + "\n");
		bw.flush();
		bw.close();
	}

}
