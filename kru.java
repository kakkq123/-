/*
 * https://www.youtube.com/watch?v=LQ3JHknGy8c
 * 영상을 참고하여 JAVA로 크루스칼 알고리즘을 구현하였다.
 */
 
import java.util.*;

class Edge {
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

class AscendingObj implements Comparator<Edge> {
	public int compare(Edge e1, Edge e2) {
		return e1.getDistance().compareTo(e2.getDistance());
	}
}

public class kru {
	//union_find
	public static int getParent(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = getParent(parent, parent[x]);
	}
	//합치기
	public static void unionParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	//같은 집합인지 확인
	public static boolean findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a == b)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		int[] table = new int[5];
		for (int i = 0; i < table.length; i++)
			table[i] = i;

		ArrayList<Edge> e = new ArrayList<Edge>();
		
		e.add(new Edge(1,2,1));
		e.add(new Edge(1,3,3));
		e.add(new Edge(2,3,3));
		e.add(new Edge(2,4,6));
		e.add(new Edge(3,4,4));
		e.add(new Edge(3,5,2));
		e.add(new Edge(4,5,5));
		
		AscendingObj ascending = new AscendingObj();
		Collections.sort(e, ascending);

		int sum = 0;
		for (int i = 0; i < e.size(); i++) {
			// 사이클이 발생하지 않으면 추가
			if (!findParent(table, e.get(i).a - 1, e.get(i).b - 1)) {
				sum += e.get(i).getDistance();
				unionParent(table, e.get(i).a - 1, e.get(i).b - 1);
			}
		}
		System.out.printf("%d",sum);

	}

}
