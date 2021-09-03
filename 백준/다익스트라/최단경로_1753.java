import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static int[] distance;				
	static final int INF = 1000000001;
	static ArrayList<Edge>[] A;			// 간선의 가중치

	static class Edge implements Comparable<Edge> {
		int cur, weight;

		public Edge(int cur, int weight) {
			this.cur = cur;
			this.weight = weight;
		}
	
		@Override
		public int compareTo(Edge edge) {
			return this.weight < edge.weight ? -1 : 1;
		}
	}

	public static void dijkstra(int start) {
		distance = new int[V + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(start, 0));

		while (!q.isEmpty()) {
			int cur = q.peek().cur, weight = q.peek().weight;
			q.poll();

			if (distance[cur] < weight)
				continue;
			for (Edge edge: A[cur]) {
				int next =edge.cur;
				int nextDistance = edge.weight;
				if (distance[next] > nextDistance + weight) {
					distance[next] = nextDistance + weight;
					q.add(new Edge(next, distance[next]));
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		A = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			A[i] = new ArrayList<Edge>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			A[u].add(new Edge(v, w));
		}
		
		dijkstra(start);
		
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF)
				bw.write("INF\n");
			else
				bw.write(distance[i] + "\n");
		}
		
		br.close();
		bw.close();
	}

}
