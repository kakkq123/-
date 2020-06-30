import java.util.*;

class Solution {
	public int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int d = routes[0][1], answer = 1;
		for (int i = 1; i < routes.length; i++) {
			if (d > routes[i][1]) {
				d = routes[i][1];
			} else if (d < routes[i][0]) {
				answer++;
				d = routes[i][1];
			}
		}
		return answer;
	}
}
