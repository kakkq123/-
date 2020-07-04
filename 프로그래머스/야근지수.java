import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
       PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i = 0; i < works.length; i++)
			q.add(works[i]);
		for(int i = 0 ; i < n; i++) {
			int t = q.poll();
			if(t > 0) 
				q.add(t - 1);
            else
                q.add(t);
		}
		long answer = 0;
		while(!q.isEmpty()) {
			answer += (long)(q.peek()*q.peek());
			q.poll();
		}
		return answer;
    }
}
