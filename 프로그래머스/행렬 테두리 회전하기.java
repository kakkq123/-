class Solution {
	static int[] answer;

	public int[][] rotate(int[][] A, int idx, int x1, int y1, int x2, int y2) {
		int rowLen = x2 - x1 + 1, colLen = y2 - y1 + 1;
		int max = Math.max(rowLen, colLen);
		int[][] tmp = new int[4][max];
		int min = 1000000;
		// 임시테이블에 저장
		for (int i = 0; i < colLen; i++) {
			tmp[0][i] = A[x1][y1 + i];
			min = Math.min(min, tmp[0][i]);
		}
		for (int i = 0; i < rowLen; i++) {
			tmp[1][i] = A[x1 + i][y2];
			min = Math.min(min, tmp[1][i]);
		}
		for (int i = 0; i < colLen; i++) {
			tmp[2][i] = A[x2][y1 + i];
			min = Math.min(min, tmp[2][i]);
		}
		for (int i = 0; i < rowLen; i++) {
			tmp[3][i] = A[x1 + i][y1];
			min = Math.min(min, tmp[3][i]);
		}

		// 회전
		for (int y = colLen - 1; y > 0; y--)
			A[x1][y1 + y] = tmp[0][y - 1];
		for (int x = rowLen - 1; x > 0; x--)
			A[x1 + x][y2] = tmp[1][x - 1];
		for (int y = 0; y < colLen - 1; y++)
			A[x2][y1 + y] = tmp[2][y + 1];
		for (int x = 0; x < rowLen - 1; x++)
			A[x1 + x][y1] = tmp[3][x + 1];
		answer[idx] = min;
		return A;
	}

	public int[] solution(int rows, int columns, int[][] queries) {
		int len = queries.length;
		answer = new int[len];
		// 배열 초기화
		int[][] A = new int[rows + 1][columns + 1];
		int num = 1;
		for (int r = 1; r <= rows; r++)
			for (int c = 1; c <= columns; c++)
				A[r][c] = num++;

		for (int i = 0; i < len; i++) {
			int x1 = queries[i][0], y1 = queries[i][1];
			int x2 = queries[i][2], y2 = queries[i][3];
			A = rotate(A, i, x1, y1, x2, y2);
		}
		return answer;
	}
}
