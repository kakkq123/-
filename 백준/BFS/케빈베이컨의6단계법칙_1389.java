import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] edge;

	static class Node {
		int num, cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//간선 연결 여부//
		edge = new int[N + 1][N + 1]; 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					edge[i][j] = 0;
				edge[i][j] = 100000;
			}
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edge[s][d] = edge[d][s] = 1;

		}
		br.close();

		//sum은 케빈 베이컨의 수를 저장함
		int[] sum = new int[N + 1];
		//각각의 케빈 베이컨의 수를 저장해놓음
		for (int i = 1; i <= N; i++)
			sum[i] = bfs(i);
		int min = sum[1], user = 1;
		//케빈 베이컨의 수가 가장 적은 user를 찾음
		for (int i = 2; i <= N; i++)
			if (min > sum[i]) {
				min = sum[i];
				user = i;
			}
		bw.write(user + "\n");
		bw.close();
	}

	private static int bfs(int start) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 1));
		boolean[] visit = new boolean[N + 1];
		visit[start] = true;
		int sum = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 1; i <= N; i++) {
				//간선이 직접 연결되어 있으며, 한 번도 방문하지 않는 노드를 큐에 담음
				//노드에 먼저 도착하면 그만큼 지나온 간선의 수도 가장 적다!!!
				if (edge[node.num][i] == 1 && !visit[i]) {
					visit[i] = true;
					sum += node.cnt;
					q.add(new Node(i, node.cnt + 1));
				}
			}
		}
		return sum;
	}

}
