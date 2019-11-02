import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Iterator;

public class _16235 {
	static int n, m, k;
	static int[][] a, nu;
	static LinkedList<Tree> tree = new LinkedList<Tree>();

	static class Tree {
		int r, c, age;
		boolean life;

		public Tree(int r, int c, int age, boolean life) {
			this.r = r;
			this.c = c;
			this.age = age;
			this.life = life;
		}
	}

	// 인덱스가 범위 안에 있는지 검사
	public static boolean isRange(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < n;
	}


	public static void solve() {
		// 봄
		for (Tree t : tree) {
			if (nu[t.r][t.c] < t.age) {
				t.life = false;
				continue;
			}
			nu[t.r][t.c] -= t.age;
			t.age++;
		}
		// 여름
		for (Iterator<Tree> iter = tree.iterator(); iter.hasNext();) {
			Tree t = iter.next();
			if (!t.life) {
				nu[t.r][t.c] += t.age / 2;
				iter.remove();
			}
		}
		// 가을
		LinkedList<Tree> tmp = new LinkedList<Tree>();
		for (Iterator<Tree> iter = tree.iterator(); iter.hasNext();) {
			Tree t = iter.next();
			if (t.age % 5 != 0)
				continue;
			for (int i = t.r - 1; i <= t.r + 1; i++)
				for (int j = t.c - 1; j <= t.c + 1; j++) {
					if (!isRange(i, j) || (i == t.r && j == t.c))
						continue;
					tmp.add(new Tree(i, j, 1, true));
				}
		}

		tree.addAll(0, tmp);
		// 겨울
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				nu[i][j] += a[i][j];

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n][n];
		nu = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
				nu[i][j] = 5;
			}
		}

		int x, y, z;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			tree.addLast(new Tree(x - 1, y - 1, z, true));
		}

		for (int i = 0; i < k; i++)
			solve();

		System.out.println(tree.size());
		br.close();
	}
}
