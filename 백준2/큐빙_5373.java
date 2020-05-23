import java.io.*;
import java.util.*;

public class Main {
	// 위 0, 아래 1, 왼 2, 앞 3, 오 4, 뒤5
	static char[][][] a;
	static char[] tmp = new char[3];
	static char[][] copy = new char[3][3];

	public static void move_L(int num) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				copy[i][j] = a[num][i][j];
		a[num][0][0] = copy[0][2];
		a[num][0][1] = copy[1][2];
		a[num][0][2] = copy[2][2];
		a[num][1][0] = copy[0][1];
		a[num][1][2] = copy[2][1];
		a[num][2][0] = copy[0][0];
		a[num][2][1] = copy[1][0];
		a[num][2][2] = copy[2][0];

	}

	public static void move_R(int num) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				copy[i][j] = a[num][i][j];
		a[num][0][0] = copy[2][0];
		a[num][0][1] = copy[1][0];
		a[num][0][2] = copy[0][0];
		a[num][1][0] = copy[2][1];
		a[num][1][2] = copy[0][1];
		a[num][2][0] = copy[2][2];
		a[num][2][1] = copy[1][2];
		a[num][2][2] = copy[0][2];
	}

	public static void rotate_1(int d) {
		for (int i = 0; i < 3; i++)
			tmp[i] = a[2][d][i];
		for (int i = 0; i < 3; i++)
			a[2][d][i] = a[3][d][i];
		for (int i = 0; i < 3; i++)
			a[3][d][i] = a[4][d][i];
		for (int i = 0; i < 3; i++)
			a[4][d][i] = a[5][d][i];
		for (int i = 0; i < 3; i++)
			a[5][d][i] = tmp[i];
	}

	public static void rotate_2(int d) {
		for (int i = 0; i < 3; i++)
			tmp[i] = a[2][d][i];
		for (int i = 0; i < 3; i++)
			a[2][d][i] = a[5][d][i];
		for (int i = 0; i < 3; i++)
			a[5][d][i] = a[4][d][i];
		for (int i = 0; i < 3; i++)
			a[4][d][i] = a[3][d][i];
		for (int i = 0; i < 3; i++)
			a[3][d][i] = tmp[i];
	}

	public static void rotate_3(int d) {
		int k = d == 0 ? 2 : 0;
		for (int i = 0; i < 3; i++)
			tmp[i] = a[0][d][i];
		for (int i = 0; i < 3; i++)
			a[0][d][i] = a[2][2 - i][d];
		for (int i = 0; i < 3; i++)
			a[2][i][d] = a[1][k][i];
		for (int i = 0; i < 3; i++)
			a[1][k][i] = a[4][2 - i][k];
		for (int i = 0; i < 3; i++)
			a[4][i][k] = tmp[i];
	}

	public static void rotate_4(int d) {
		int k = d == 0 ? 2 : 0;
		for (int i = 0; i < 3; i++)
			tmp[i] = a[0][d][i];
		for (int i = 0; i < 3; i++)
			a[0][d][i] = a[4][i][k];
		for (int i = 0; i < 3; i++)
			a[4][i][k] = a[1][k][2 - i];
		for (int i = 0; i < 3; i++)
			a[1][k][i] = a[2][i][d];
		for (int i = 0; i < 3; i++)
			a[2][i][d] = tmp[2 - i];
	}

	public static void rotate_5(int d) {
		int k = d == 0 ? 2 : 0;
		for (int i = 0; i < 3; i++)
			tmp[i] = a[0][i][d];
		for (int i = 0; i < 3; i++)
			a[0][i][d] = a[5][2 - i][k];
		for (int i = 0; i < 3; i++)
			a[5][i][k] = a[1][2 - i][d];
		for (int i = 0; i < 3; i++)
			a[1][i][d] = a[3][i][d];
		for (int i = 0; i < 3; i++)
			a[3][i][d] = tmp[i];
	}

	public static void rotate_6(int d) {
		int k = d == 0 ? 2 : 0;
		for (int i = 0; i < 3; i++)
			tmp[i] = a[0][i][d];
		for (int i = 0; i < 3; i++)
			a[0][i][d] = a[3][i][d];
		for (int i = 0; i < 3; i++)
			a[3][i][d] = a[1][i][d];
		for (int i = 0; i < 3; i++)
			a[1][i][d] = a[5][2 - i][k];
		for (int i = 0; i < 3; i++)
			a[5][i][k] = tmp[2 - i];
	}

	public static void solve(char c, char dir) {
		// U: 윗 면, D: 아랫 면, F: 앞 면, B: 뒷 면, L: 왼쪽 면, R: 오
		switch (c) {
		case 'U':
			if (dir == '+') {
				move_R(0);
				rotate_1(0);
			} else {
				move_L(0);
				rotate_2(0);
			}
			break;
		case 'D':
			if (dir == '+') {
				move_R(1);
				rotate_2(2);
			} else {
				move_L(1);
				rotate_1(2);
			}
			break;
		case 'L':
			if (dir == '+') {
				move_R(2);
				rotate_5(0);
			} else {
				move_L(2);
				rotate_6(0);
			}
			break;
		case 'F':
			if (dir == '+') {
				move_R(3);
				rotate_3(2);
			} else {
				move_L(3);
				rotate_4(2);
			}
			break;
		case 'R':
			if (dir == '+') {
				move_R(4);
				rotate_6(2);
			} else {
				move_L(4);
				rotate_5(2);
			}
			break;
		default:
			if (dir == '+') {
				move_R(5);
				rotate_4(0);
			} else {
				move_L(5);
				rotate_3(0);
			}
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		char[] c = { 'w', 'y', 'g', 'r', 'b', 'o' };
		int test = Integer.parseInt(br.readLine());
		for (int t = 0; t < test; t++) {
			a = new char[6][3][3];
			for (int k = 0; k < 6; k++)
				for (int i = 0; i < 3; i++)
					for (int j = 0; j < 3; j++)
						a[k][i][j] = c[k];
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				String s = st.nextToken();
				solve(s.charAt(0), s.charAt(1));
			}
			for (int i = 0; i < 3; i++)
				bw.write(a[0][i][0] + "" + a[0][i][1] + "" + a[0][i][2] + "\n");
		}
		br.close();
		bw.close();

	}

}
