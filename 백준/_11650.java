import java.util.*;

public class _11650 {
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

		// ÀÔ·Â
		for (int i = 0; i < n; i++) {
			p.add(new Point(kb.nextInt(), kb.nextInt()));
		}
		// ¿À¸§Â÷¼øÀ¸·Î Á¤·Ä
		Ascending a = new Ascending();
		Collections.sort(p, a);

		// print
		for (int i = 0; i < n; i++)
			System.out.println(p.get(i));
	}

}
