import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] degree = new int[N + 1];

		// 간선 연결!
		List<Integer>[] edge = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			edge[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a].add(b);
			degree[b]++;
		}

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();		// 난이도가 쉬운 문제부터 푼다.
		// 진입 차수가 0인 문제번호를 우선순위큐에 삽입
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				pq.add(i);
				visited[i] = true;
			}
		}
		int[] result = new int[N];
		int idx = 0;
		while (!pq.isEmpty()) {
			int Node = pq.poll();
			result[idx++] = Node;
			for(int next : edge[Node]) {
				if(visited[next])
					continue;
				if(--degree[next] == 0) {
					visited[next] = true;
					pq.add(next);
				}
			}
		}
		for(int res: result) {
			bw.write(res+" ");
		}
		br.close();
		bw.close();
	}

}
