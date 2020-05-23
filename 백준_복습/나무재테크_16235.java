import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] A, a;
	static Deque<Tree> tree = new LinkedList<Tree>();

	static class Tree {
		int r, c, age;
		boolean flag;

		public Tree(int r, int c, int age, boolean flag) {
			this.r = r;
			this.c = c;
			this.age = age;
			this.flag = flag;
		}
	}

	public static void solve() {
		// 봄
		for (Tree t : tree) {
			if (a[t.r][t.c] < t.age) {
				t.flag = false;
			} else {
				a[t.r][t.c] -= t.age;
				t.age++;
			}
		}
		// 여름
		for (Iterator<Tree> iter = tree.iterator(); iter.hasNext();) {
			Tree t = iter.next();
			if (!t.flag) {
				a[t.r][t.c] += t.age / 2;
				iter.remove();
			}
		}
		// 가을
		Deque<Tree> tmp = new LinkedList<Tree>();
		for (Iterator<Tree> iter = tree.iterator(); iter.hasNext();) {
			Tree t = iter.next();
			if (t.age % 5 == 0){
				for (int i = t.r - 1; i <= t.r + 1; i++) {
					for (int j = t.c - 1; j <= t.c + 1; j++) {
						if (i == t.r && t.c == j)
							continue;
						if (i >= 1 && i <= N && j >= 1 && j <= N) {
							tmp.add(new Tree(i, j, 1, true));
						}
					}
				}
			}
		}
		while(!tmp.isEmpty()) {
			tree.addFirst(tmp.poll());
		}
		// 겨울
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				a[i][j] += A[i][j];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x, y, z;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N + 1][N + 1];
		a = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				a[i][j] = 5;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			tree.addLast(new Tree(x, y, z, true));
		}
		br.close();

		for (int i = 0; i < K; i++) {
			solve();
		}
		System.out.println(tree.size());
	}

}
