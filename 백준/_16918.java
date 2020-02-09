import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16918 {
	static int r, c;
	static int[][] time;

	//폭탄 설치
	public static void fill(int t) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (time[i][j] == 0)
					time[i][j] = t + 3;
			}
		}
	}

	//폭탄 폭발
	public static void explode(int t) {
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };
		int[][] copy = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				copy[i][j] = time[i][j];
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (copy[i][j] == t) {
					time[i][j] = 0;
					for (int d = 0; d < 4; d++) {
						int tr = i + dr[d], tc = j + dc[d];
						if (tr < 0 || tr >= r || tc < 0 || tc >= c)
							continue;
						time[tr][tc] = 0;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		time = new int[r][c];
		for (int i = 0; i < r; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (tmp[j] == 'O')
					time[i][j] = 3;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1)
				explode(i);
			else
				fill(i);
		}
		
		// PRINT
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (time[i][j] == 0)
					System.out.printf(".");
				else
					System.out.printf("O");
			}
			System.out.println();
		}
		br.close();
	}

}
