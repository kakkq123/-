import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15683 {
	static int n, m, min = Integer.MAX_VALUE, size = 0;
	static int[][] office;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 }, rotation = { 0, 4, 2, 4, 4, 1 }, t = new int[8];
	static int[][] arr = new int[8][2];
	
	public static class Pos{
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 사무실 범위 안에 있는지 검사
	public static boolean isRange(int r, int c) {
		return r >= 0 && r < n && c >= 0 && c < m;
	}

	// 사각지대 최솟값 계산
	public static void blind_spot() {
		// copy
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				tmp[i][j] = office[i][j];
		//
		int i = 0;
		while (i < size) {
			switch (tmp[arr[i][0]][arr[i][1]]) {
			case 1:
				fillup(arr[i][0], arr[i][1], t[i], tmp);
				break;
			case 2:
				fillup(arr[i][0], arr[i][1], (0 + t[i])%4, tmp);
				fillup(arr[i][0], arr[i][1], (2 + t[i])%4, tmp);
				break;
			case 3:
				fillup(arr[i][0], arr[i][1], (0 + t[i]) % 4, tmp);
				fillup(arr[i][0], arr[i][1], (1 + t[i]) % 4, tmp);
				break;
			case 4:
				fillup(arr[i][0], arr[i][1], (0 + t[i]) % 4, tmp);
				fillup(arr[i][0], arr[i][1], (1 + t[i]) % 4, tmp);
				fillup(arr[i][0], arr[i][1], (2 + t[i]) % 4, tmp);
				break;
			case 5:
				fillup(arr[i][0], arr[i][1], 0, tmp);
				fillup(arr[i][0], arr[i][1], 1, tmp);
				fillup(arr[i][0], arr[i][1], 2, tmp);
				fillup(arr[i][0], arr[i][1], 3, tmp);
				break;

			}
			i++;
		}
		int zone = 0;
		for (i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 0)
					zone++;
				//
				if (zone > min)
					break;
			}
		}
		min = Math.min(min, zone);

	}

	// 감시 가능한 영역 7로 표기
	public static void fillup(int r, int c, int d, int[][] tmp) {
		while (isRange(r, c) && tmp[r][c] != 6) {
			if (tmp[r][c] == 0)
				tmp[r][c] = 7;
			r += dr[d];
			c += dc[d];
		}
	}

	public static void dfs(int index) {
		if (index == size) {
			blind_spot();
			return;
		}
		int num = office[arr[index][0]][arr[index][1]];

		for (int i = 0; i < rotation[num]; i++) {
			t[index] = i;
			dfs(index + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		//
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		office = new int[n][m];
		//
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] >= 1 && office[i][j] <= 5) {
					arr[size][0] = i;
					arr[size][1] = j;
					size++;
				}
			}
		}
		dfs(0);
		System.out.println(min);
		br.close();
	}
}
