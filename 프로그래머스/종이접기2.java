class Solution {
	public int[] solution(int n) {
		if (n == 1)
			return new int[] { 0 };
		if (n == 2)
			return new int[] { 0, 0, 1 };
		int[] answer = new int[(int) Math.pow(2, n) - 1];
		int[] t = solution(n - 1);
		for (int i = 0; i < answer.length / 2; i++)
			answer[i] = t[i];
		answer[answer.length / 2] = 0;
		for (int i = answer.length / 2 + 1; i < answer.length; i++)
			answer[i] = answer[i - 2 * (i - answer.length / 2)] == 0 ? 1 : 0;
		return answer;
	}
}
