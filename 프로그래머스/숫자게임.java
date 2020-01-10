import java.util.Arrays;

class Solution {
	public int check(int[] A, int[] B, int a, int b) {
		int num = 0;
		for (int i = 0; i <= a; i++) {
			if (A[i] < B[i + b])
				num++;
		}
		return num;
	}

	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		if (A[0] > B[B.length - 1])
			return 0;

		int answer = 0;
		for (int i = 0; i < A.length; i++) {
			if (A.length - i < answer)
				break;
			answer = Math.max(answer, check(A, B, A.length - i - 1, i));
		}
		return answer;
	}
}
