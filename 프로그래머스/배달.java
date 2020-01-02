class Solution {
	static int[][] d;
	static boolean[] visit;
	static int[] distance;

	public int get_small_index(int n) {
		int min = 10000000;
		int index = 0;
		for (int i = 1; i <= n; i++)
			if (min > distance[i] && !visit[i]) {
				min = distance[i];
				index = i;
			}
		return index;
	}

	public void dijkstra(int n) {
		for (int i = 1; i <= n; i++)
			distance[i] = d[1][i];

		visit[1] = true;
		for (int i = 1; i <= n - 1; i++) {
			int cur = get_small_index(n);
			visit[cur] = true;
			for (int j = 0; j <= n; j++) {
				if (!visit[j] && distance[cur] + d[cur][j] < distance[j])
					distance[j] = distance[cur] + d[cur][j];
			}
		}
	}

	public int solution(int n, int[][] road, int k) {
		d = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		distance = new int[n + 1];

		for (int i = 2; i <= n; i++)
			distance[i] = 10000000;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++) {
				if (i == j)
					d[i][j] = 0;
				else
					d[i][j] = 10000000;
			}
		for (int i = 0; i < road.length; i++) {
			if (d[road[i][0]][road[i][1]] > road[i][2]) {
				d[road[i][0]][road[i][1]] = road[i][2];
				d[road[i][1]][road[i][0]] = road[i][2];
			}
		}

		dijkstra(n);
		int answer = 0;
		for (int i = 1; i <= n; i++)
			if (distance[i] <= k)
				answer++;
		return answer;
	}
}
