import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17144 {
	static int r, c, t, a1 = -1, a2;
	static int[][] room;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	public static boolean isRange(int a, int b) {
		return a >= 0 && a < r && b >= 0 && b < c && room[a][b] != -1;
	}

	public static void diffusion() {
		int[][] tmp = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (room[i][j] >= 5) {
					int t = room[i][j] / 5;
					for (int k = 0; k < 4; k++) {
						if (isRange(i + dr[k], j + dc[k])) {
							tmp[i + dr[k]][j + dc[k]] += t;
							room[i][j] -= t;
						}
					}
				}
			}
		}

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				room[i][j] += tmp[i][j];
		
		// 공기청정기1
		for (int i = a1 - 1; i > 0; i--)
			room[i][0] = room[i - 1][0];
		for (int i = 0; i < c - 1; i++)
			room[0][i] = room[0][i + 1];
		for (int i = 0; i < a1; i++)
			room[i][c - 1] = room[i + 1][c - 1];
		for (int i = c - 1; i > 0; i--)
			room[a1][i] = room[a1][i - 1];
		room[a1][1] = 0;
		// 공기청정기2
		for (int i = a2 + 1; i < r - 1; i++)
			room[i][0] = room[i + 1][0];
		for (int i = 0; i < c - 1; i++)
			room[r - 1][i] = room[r - 1][i + 1];
		for (int i = r - 1; i >= a2 + 1; i--)
			room[i][c - 1] = room[i - 1][c - 1];
		for (int i = c - 1; i > 0; i--)
			room[a2][i] = room[a2][i - 1];
		room[a2][1] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		room = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					if (a1 == -1)
						a1 = i;
					else
						a2 = i;
				}
			}
		}

		for (int i = 0; i < t; i++) 
			diffusion();

		int sum = 0;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++) {
				if (room[i][j] == -1)
					continue;
				sum += room[i][j];
			}
		System.out.println(sum);
		br.close();

	}

}
