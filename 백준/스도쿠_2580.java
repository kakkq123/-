import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class 스도쿠_2580 {
	static int[][] a = new int[9][9];
	static LinkedList<Pos> list = new LinkedList<Pos>();

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static boolean check(int r, int c, int value) {
		for (int i = 0; i < 9; i++)
			if (a[r][i] == value)
				return false;
		for (int i = 0; i < 9; i++)
			if (a[i][c] == value)
				return false;
		int nr = r / 3 * 3, nc = c / 3 * 3;
		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++)
				if (a[i][j] == value)
					return false;
		}
		return true;
	}

	public static void dfs(int index) {
		if (index == list.size()) {
			// PRINT
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.printf("%d ", a[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}

		int r = list.get(index).r, c = list.get(index).c;
		for (int i = 1; i <= 9; i++) {
			if (check(r, c, i)) {
				a[r][c] = i;
				dfs(index + 1);
				a[r][c] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				if (a[i][j] == 0)
					list.add(new Pos(i, j));
			}
		}
		dfs(0);

		br.close();

	}

}
