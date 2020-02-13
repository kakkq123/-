import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양팔저울_2629_2 {
	static int n;
	static int[] a;
	static boolean[][] visit;

	public static void dfs(int index, int value) {
		if (visit[index][value])
			return;
		visit[index][value] = true;
		if (index == n)
			return;
		dfs(index + 1, value + a[index]);
		dfs(index + 1, value);
		dfs(index + 1, Math.abs(value - a[index]));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		visit = new boolean[n + 1][40001];
		for (int i = 0; i < m; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			dfs(0, 0);
			if (visit[n][tmp])
				System.out.printf("Y ");
			else
				System.out.printf("N ");
		}
		br.close();
	}

}
