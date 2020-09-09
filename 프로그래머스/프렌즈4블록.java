class Solution {
    static char[][] b;
    public int solution(int m, int n, String[] board) {
     	int answer = 0;
		b = new char[m][n];
		for (int i = 0; i < m; i++)
			b[i] = board[i].toCharArray();

		boolean flag;
		while (true) {
			flag = false;
			boolean[][] delete = new boolean[m][n];

			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					// 0은 빈칸을 의미함
					if (b[i][j] == '0')
						continue;
					// 4블록을 지울 수 있는가?
					if (b[i][j] == b[i][j + 1] && b[i][j] == b[i + 1][j] && b[i][j] == b[i + 1][j + 1]) {
						delete[i][j] = delete[i + 1][j] = delete[i][j + 1] = delete[i + 1][j + 1] = true;
						flag = true;
					}
				}
			}
			// 삭제할 블록이 없다면 break
			if (!flag)
				break;
			// delete
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					if (delete[i][j]) {
						b[i][j] = '0';
						answer++;
					}
			// 블록들 내려오기
			for (int i = m - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					if (b[i][j] == '0') {
						int d = 0, r = i;
						while (r >= 0 && b[r][j] == '0') {
							d++;
							r--;
						}
						if (d > 0) {
							for (int k = r; k >= 0; k--)
								b[k + d][j] = b[k][j];

							for (int k = 0; k < d; k++)
								b[k][j] = '0';

						}
					}
				}
			}
		}
		return answer;
    }
}
