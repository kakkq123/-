import java.util.*;
import java.awt.Point;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0, len = truck_weights.length, cnt = 0, w = 0, index = 0;
		LinkedList<Point> a = new LinkedList<Point>();
		Deque<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < len; i++)
			q.add(truck_weights[i]);
		while (cnt < len) {
			time++;
			for (Iterator<Point> iter = a.iterator(); iter.hasNext();) {
				Point p = iter.next();
				p.y++;
				if (p.y > bridge_length) {
					w -= p.x;
					iter.remove();
					cnt++;
				}
			}
			if (!q.isEmpty() && q.peekFirst() + w <= weight) {
				index++;
				a.add(new Point(q.peekFirst(), 1));
				w += q.pollFirst();
			}
		}
		return time;
    }
}
