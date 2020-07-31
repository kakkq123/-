/*
 * M*N의 보드가 주어진다.
 8*8크기의 체스판으로 잘라낸 후에, 변을 공유하는 두 개의 사각형이 같은 색이 아니도록 W 또는 B으로 색칠해야 한다.
 8*8크기로 자른 뒤에 다시 칠해야하는 정사각형 개수의 최솟값을 구하는 프로그램을 작성하시오.
*/
import java.util.Scanner;

public class _1018 {

	static char[][] board;

	// 알파벳 변경
	public static char change(char c) {
		if (c == 'B')
			return 'W';
		return 'B';
	}

	// BWBW...로 변경할 때 알파벳 변경해야하는 개수
	public static int start_BW(int i, int j) {
		int r = 0;
		char s = 'B', t=s;
		for (int a = j; a < j + 8; a++) {
			if (board[i][a] != t)
				r++;
			t = change(t);
		}
	
		for (int a = i + 1; a < i + 8; a++) {
			t=s=change(s);
			for (int b = j; b < j + 8; b++) {
				if (board[a][b] != t)
					r++;
				t = change(t);
			}
		}
		return r;
	}

	// WBWB...로 변경할 때 알파벳 변경해야하는 개수
	public static int start_WB(int i, int j) {
		int r = 0;
		char s = 'W', t=s;
		for (int a = j; a < j + 8; a++) {
			if (board[i][a] != t)
				r++;
			t = change(t);
		}
	
		for (int a = i + 1; a < i + 8; a++) {
			t=s=change(s);
			for (int b = j; b < j + 8; b++) {
				if (board[a][b] != t)
					r++;
				t = change(t);
			}
		}
		return r;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int m = kb.nextInt();
		int n = kb.nextInt();
		board = new char[m][n];
		String s;
		int res = 1000000, tmp = 0;

		for (int i = 0; i < m; i++) {
			s = kb.next();
			for (int j = 0; j < s.length(); j++)
				board[i][j] = s.charAt(j); // String->char로 변환
		}

		// 8*8
		for (int i = 0; i <= m - 8; i++) {
			for (int j = 0; j <= n - 8; j++) {
				tmp = Math.min(start_BW(i, j), start_WB(i, j));
				res = Math.min(res, tmp);
			}
		}

		// 결과
		System.out.println(res);
	}

}
