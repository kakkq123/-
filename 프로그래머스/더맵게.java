import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			q.add(scoville[i]);
		}
		int scov = 0;
			while (true) {
			int a = q.poll();
            // 모든 음식의 스코빌 지수를 K 이상
			if(a >= K)
				return answer;
            // 새로운 음식의 스코빌 지수를 만들지 못하면
			if(q.size() < 1)
				break;
			int b = q.poll();
			scov = a + b * 2;
			q.add(scov);
			answer++;
		}
		return -1;
    }
}
