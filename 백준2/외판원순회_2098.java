import java.util.*;
import java.io.*;

public class 외판원순회_2098 {
	static int[][] w = new int[16][16], dp = new int[16][1 << 16];
	static int n, INF = 2000000000;

	public static int tsp(int from, int path, int len) {
		// 마지막 노드에 도착한 경우
		if (len == 0) {
			//모든 도시간의 비용은 양의 정수라고 했으니 0이라는 의미는 길이 없다는 의미....!
			if (w[from][0] != 0)
				return w[from][0];
			else
				return INF;
		}
		// 이미 dp의 값이 존재할 경우 계산 X
		if (dp[from][path] > 0)
			return dp[from][path];
		// dp값을 계산
		dp[from][path] = INF;
		for (int to = 0; to < n; to++) {
			int node = 1 << to;
			if ((node & path) > 0 && w[from][to] > 0) {
				int npath = (path & ~node); 
				int neww = w[from][to] + tsp(to, npath, len - 1);
				dp[from][path] = Math.min(dp[from][path], neww);
			}
		}
		return dp[from][path];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				w[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();

		int path = 0;
		for (int i = 0; i < n; i++) {
			path |= 1 << i;
		}
		//어디서 시작하든 상관 없음 그냥 0에서 시작한다고 가정하고 TSP 돌림
		int npath = (path & ~(1 << 0));
		System.out.println(tsp(0, npath, n - 1));

	}

}
