import java.util.*;
class Solution {
	static int[] d;

	static class Edge {
		int a, b;
		private int distance;

		public Edge(int a, int b, int distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		public Integer getDistance() {
			return distance;
		}
	}

	static class AscendingObj implements Comparator<Edge> {
		public int compare(Edge e1, Edge e2) {
			return e1.getDistance().compareTo(e2.getDistance());
		}
	}

	public static int getParent(int[] set, int k) {
		if (set[k] == k)
			return k;
		return set[k] = getParent(set, set[k]);
	}

	public static void unionSet(int[] set, int a, int b) {
		a = getParent(set, a);
		b = getParent(set, b);
		if (a < b)
			set[b] = a;
		else
			set[a] = b;
	}

	public static boolean findParent(int[] set, int a, int b) {
		a = getParent(set, a);
		b = getParent(set, b);
		if (a == b)
			return true;
		else
			return false;
	}

	public static int solution(int n, int[][] costs) {
		d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = i;
		}
		ArrayList<Edge> e = new ArrayList<Edge>();
		for (int i = 0; i < costs.length; i++) {
			e.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
		}
		AscendingObj ascending = new AscendingObj();
		Collections.sort(e, ascending);

		int sum = 0;
		for (int i = 0; i < e.size(); i++) {
			// 사이클이 발생하지 않으면 추가
			if (!findParent(d, e.get(i).a, e.get(i).b)) {
				sum += e.get(i).getDistance();
				unionSet(d, e.get(i).a, e.get(i).b);
			}
		}
		return sum;
    }
}
