class Solution {
	public int solution(int n, int[] stations, int w) {
		int index = 1, answer = 0, s = 0, num = 2 * w + 1;
		while (index <= n) {
			if (s < stations.length) {
				if (index < stations[s] - w) {
					int tmp = stations[s] - w - index;
					int add = tmp % num == 0 ? tmp / num : tmp / num + 1;
					answer += add;
				}
				index = stations[s] + w + 1;
				s++;
			} else {
				int tmp = n - index + 1;
				int add = tmp % num == 0 ? tmp / num : tmp / num + 1;
				answer += add;
				index = n + 1;
			}
		}
		return answer;
	}
}
