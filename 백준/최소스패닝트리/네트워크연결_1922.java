import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int a, b, distance;

		public Edge(int a, int b, int distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge e) {
			return this.distance - e.distance;
		}
	}

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parent[i] = i;

		m = Integer.parseInt(br.readLine());

		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			q.add(new Edge(a, b, dis));
		}

		int sum = 0;
		while (!q.isEmpty()) {
			if (!findParent(q.peek().a, q.peek().b)) {
				sum += q.peek().distance;
				unionSet(q.peek().a, q.peek().b);
			}
			q.poll();
		}
		bw.write(sum + "\n");
		br.close();
		bw.close();

	}

	private static int getParent(int k) {
		if (parent[k] == k)
			return k;
		return parent[k] = getParent(parent[k]);
	}

	private static void unionSet(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	private static boolean findParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a == b)
			return true;
		else
			return false;
	}

}
