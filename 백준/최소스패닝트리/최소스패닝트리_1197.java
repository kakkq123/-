import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;

	static class Vertex implements Comparable<Vertex> {
		int x, y, dis;

		public Vertex(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}

		public int compareTo(Vertex v) {
			return this.dis - v.dis;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		//가중치가 작은 순으로 정렬
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			q.add(new Vertex(a, b, c));
		}
		br.close();

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parent[i] = i;

		long sum = 0;
		while (!q.isEmpty()) {
			int x = q.peek().x, y = q.peek().y, dis = q.peek().dis;
			q.poll();
			//연결되어 있음
			if (getParent(x) == getParent(y))
				continue;
			sum += dis;
			setParent(x, y);
		}
		bw.write(sum + "\n");
		bw.close();
	}

	private static void setParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	private static int getParent(int x) {
		if (parent[x] == x)
			return x;
		return getParent(parent[x]);
	}

}
