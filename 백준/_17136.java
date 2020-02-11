import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136 {
	static int cnt = 0, ans = 26;

	public static boolean range(int r, int c) {
		return r >= 0 && r < 10 && c >= 0 && c < 10;
	}

	public static boolean check(int r, int c, int size, int[][] a) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (!range(i, j) || a[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static void visit(int r, int c, int size, int[][] a, int[][] copy) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i >= r && i < r + size && j >= c && j < c + size) {
					copy[i][j] = 0;
				} else {
					copy[i][j] = a[i][j];
				}
			}
		}
	}

	// p[0]: 총 색종이 개수를 의미, p[1]...p[5]: 각 색종이 개수를 의미
	public static void dfs(int r, int c, int total, int[] p, int[][] a) {
		if (p[0] > ans)
			return;
		if (total == cnt) {
			ans = p[0];
			return;
		}
		int x = c == 10 ? r + 1 : r;
		for (int i = x; i < 10; i++) {
			int y = i == r ? c : 0;
			for (int j = y; j < 10; j++) {
				// 색종이 붙이기
				if (a[i][j] == 1) {
					for (int size = 5; size >= 1; size--) {
						if (p[size] == 5)
							continue;
						if (check(i, j, size, a)) {
							int[] tmp = p.clone();
							tmp[size]++; // 해당 사이즈 색종이 개수 1 증가
							tmp[0]++; // 총 색종이 개수 1 증가
							int[][] copy = new int[10][10];
							visit(i, j, size, a, copy);
							dfs(i, j, total + (size * size), tmp, copy);
						}
					}
				}
				// a[i][j]에 색종이를 붙이지 않고 넘어가는 경우 return
				if (a[i][j] == 1)
					return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] a = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 1)
					cnt++;
			}
		}

		int[] p = { 0, 0, 0, 0, 0, 0 };
		dfs(0, 0, 0, p, a);
		ans = ans == 26 ? -1 : ans;
		System.out.println(ans);

		br.close();

	}

}
