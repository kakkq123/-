import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행_2157 {
	static int n, m, k;
	static int[][] d, c;

	public static int solve(int index, int num) {
		if (index == n)
			return 0;
		if (num == m)
			return Integer.MIN_VALUE;
		if (c[index][num] > 0)
			return c[index][num];
		int tmp = Integer.MIN_VALUE;
		for (int i = index + 1; i <= n; i++) {
			if (d[index][i] > 0) {
				tmp = Math.max(tmp, d[index][i] + solve(i, num + 1));
			}
		}
		return c[index][num] = tmp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		d = new int[n + 1][n + 1]; 
		c = new int[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			d[a][b] = Math.max(c, d[a][b]);
		}
		System.out.println(solve(1, 1));
	}

}
