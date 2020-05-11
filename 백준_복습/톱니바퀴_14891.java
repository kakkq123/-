import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void left(int[][] a, int num) {
		int tmp = a[num][0];
		for (int i = 1; i < 8; i++) {
			a[num][i - 1] = a[num][i];
		}
		a[num][7] = tmp;
	}

	public static void right(int[][] a, int num) {
		int tmp = a[num][7];
		for (int i = 7; i > 0; i--) {
			a[num][i] = a[num][i - 1];
		}
		a[num][0] = tmp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] a = new int[5][8];
		for (int i = 1; i <= 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++)
				a[i][j] = s.charAt(j) - '0';
		}

		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int[] dir = new int[5];
			int num = Integer.parseInt(st.nextToken());
			dir[num] = Integer.parseInt(st.nextToken());
			// left
			for (int j = num - 1; j > 0; j--) {
				if (a[j + 1][6] != a[j][2])
					dir[j] = -dir[j + 1];
			}
			// right
			for (int j = num + 1; j <=4; j++) {
				if (a[j - 1][2] != a[j][6])
					dir[j] = -dir[j - 1];
			}
			for (int j = 1; j <= 4; j++) {
				if (dir[j] == 1)
					right(a, j);
				else if (dir[j] == -1)
					left(a, j);
			}
			
		}
		int score = 0;
		if (a[1][0] == 1)
			score += 1;
		if (a[2][0] == 1)
			score += 2;
		if (a[3][0] == 1)
			score += 4;
		if (a[4][0] == 1)
			score += 8;
		System.out.println(score);
		br.close();
	}

}
