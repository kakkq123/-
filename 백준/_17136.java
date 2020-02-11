import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136 {
	static int ans = 26;

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

	// p[0]: 색종이 총 개수, p[1]...p[5]: 각 색종이 개수
	public static void dfs(int r, int c, int total, int cnt, int[] p, int[][] a) {
		if (p[0] > ans)
			return;
		if (total == cnt) {
			ans = p[0];
			return;
		}
		for (int i = r; i < 10; i++) {
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
							for (int nr = i; nr < i + size; nr++)
								for (int nc = j; nc < j + size; nc++)
									a[nr][nc] = 0;
							dfs(i, j, total + (size * size), cnt, tmp, a);
							for (int nr = i; nr < i + size; nr++)
								for (int nc = j; nc < j + size; nc++)
									a[nr][nc] = 1;
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
		int cnt = 0;
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
		dfs(0, 0, 0, cnt, p, a);
		ans = ans == 26 ? -1 : ans;
		System.out.println(ans);

		br.close();

	}

}
