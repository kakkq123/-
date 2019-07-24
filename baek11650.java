import java.util.*;

public class baek11650 {
	public static class Point {
		private int x;
		private int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Integer getX() {
			return x;
		}

		public Integer getY() {
			return y;
		}

		public String toString() {
			return this.x + " " + this.y;
		}

	}

	static class Ascending implements Comparator<Point> {
		public int compare(Point p1, Point p2) {
			if (p1.getX() == p2.getX())
				return p1.getY().compareTo(p2.getY());
			return p1.getX().compareTo(p2.getX());
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Point> p = new ArrayList<Point>();

		// 입력
		for (int i = 0; i < n; i++) {
			p.add(new Point(kb.nextInt(), kb.nextInt()));
		}
		// 오름차순으로 정렬
		Ascending a = new Ascending();
		Collections.sort(p, a);

		// print
		for (int i = 0; i < n; i++)
			System.out.println(p.get(i));
	}

}
