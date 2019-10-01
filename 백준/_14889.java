import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14889 {
	static int n, min = Integer.MAX_VALUE;
	static int[][] s;
	static int[] start_team, link_team;

	public static int start() {
		int sum = 0;
		for (int i = 1; i < start_team.length - 1; i++) {
			for (int j = i + 1; j < start_team.length; j++) {
				sum += s[start_team[i]][start_team[j]] + s[start_team[j]][start_team[i]];
			}
		}
		return sum;
	}

	public static int link() {
		int sum = 0;
		for (int i = 1; i < link_team.length - 1; i++) {
			for (int j = i + 1; j < link_team.length; j++) {
				sum += s[link_team[i]][link_team[j]] + s[link_team[j]][link_team[i]];

			}
		}
		return sum;
	}

	public static void solve(int index, int s_team, int l_team) {
		if (index == n) {
			int t1 = start();
			int t2 = link();
			min = Math.min(min, Math.abs(t1 - t2));
			return;
		}
		if (s_team < n / 2) {
			start_team[s_team + 1] = index + 1;
			solve(index + 1, s_team + 1, l_team);
		}
		if (l_team < n / 2) {
			link_team[l_team + 1] = index + 1;
			solve(index + 1, s_team, l_team + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n + 1][n + 1];
		start_team = new int[n / 2 + 1];
		link_team = new int[n / 2 + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, 0);
		System.out.println(min);
		br.close();

	}

}
