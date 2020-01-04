import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int[] solution(int n) {
		Queue<Integer> list = new LinkedList<Integer>();
		Queue<Integer> tmp = new LinkedList<Integer>();
		int[] answer = new int[(int) Math.pow(2, n) - 1];

		for (int i = 0; i < n; i++) {
			if (list.isEmpty()) {
				list.add(0);
				continue;
			}
			for (int j = 0; j < (int) Math.pow(2, i) - 1; j++) {
				if (j % 2 == 0)
					tmp.offer(0);
				else
					tmp.offer(1);
				tmp.add(list.poll());
			}
			tmp.offer(1);
			// copy
			while (!tmp.isEmpty()) {
				list.offer(tmp.poll());
			}
		}
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.poll();

		return answer;
	}
}
