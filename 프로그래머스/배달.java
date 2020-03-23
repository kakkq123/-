import java.util.*;
//프로그래머스_배달
class Solution {
	static int INF = 9000000;
	static int[] d;

	static class Node {
		int next, time;

		public Node(int next, int time) {
			this.next = next;
			this.time = time;
		}
	}

	public void bfs(int N, ArrayList<Node>[] a, int K) {
		d = new int[N + 1];
		Arrays.fill(d, INF);
		d[1] = 0;
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 0));

		while (!q.isEmpty()) {
			int cur = q.peek().next, time = q.peek().time;
			q.poll();
			if (d[cur] > time)
				continue;
			for (Node n : a[cur]) {
				int next = n.next, next_time = time + n.time;
				if (d[next] > next_time) {
					d[next] = next_time;
					q.add(new Node(next, next_time));
				}
			}
		}

	}

	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		ArrayList<Node>[] a = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < road.length; i++) {
			a[road[i][0]].add(new Node(road[i][1], road[i][2]));
			a[road[i][1]].add(new Node(road[i][0], road[i][2]));
		}
		bfs(N, a, K);
		for (int i = 1; i <= N; i++)
			if (d[i] <= K)
				answer++;
		return answer;
	}
}
