import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14501 {

	static int[] t;
	static int[] p;
	static int n, max = 0;

	public static int dfs(int day, int res) {
		if (day > n)
			return max = Math.max(max, res);
		
		if (day + t[day] <= n+1) 
			dfs(day + t[day], res + p[day]);

		return dfs(day + 1, res);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s;
		s = new StringTokenizer(br.readLine());
		n = Integer.parseInt(s.nextToken());
		t = new int[n + 1];
		p = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			s = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(s.nextToken());
			p[i] = Integer.parseInt(s.nextToken());

		}

		System.out.println(dfs(1, 0));

		br.close();
	}

}
