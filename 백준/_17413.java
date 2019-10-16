import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class _17413 {
	public static class Fish implements Comparable<Fish> {
		int r, c, s, d, z;

		public Fish(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Fish f) {
			if (this.r == f.r) {
				if (this.c == f.c)
					return this.z < f.z ? 1 : -1;
				else
					return this.c < f.c ? -1 : 1;
			}
			return this.r < f.r ? -1 : 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 };
		LinkedList<Fish> fish = new LinkedList<Fish>();

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int r, c, s, d, z, sum = 0;
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			fish.add(new Fish(r - 1, c - 1, s, d - 1, z));
		}

		for (int i = 0; i < col; i++) {
			Collections.sort(fish);
			// 상어 잡음
			for (Iterator<Fish> iter = fish.iterator(); iter.hasNext();) {
				Fish f = iter.next();
				if (i == f.c) {
					sum += f.z;
					iter.remove();
					break;
				}
			} // 상어 잡음

			// 상어이동....!
			for (Iterator<Fish> iter = fish.iterator(); iter.hasNext();) {
				Fish f = iter.next();
				int ns = f.s;
				int nd = f.d;
				if (nd < 2) {
					int nr = f.r;
					while (ns > 0) {
						if (nr == 0 && nd == 0)
							nd = 1;
						else if (nr == row - 1 && nd == 1)
							nd = 0;
						nr += dr[nd];
						ns--;
					}
					f.r = nr;
				} else {
					int nc = f.c;
					while (ns > 0) {
						if (nc == 0 && nd == 3)
							nd = 2;
						else if (nc == col - 1 && nd == 2)
							nd = 3;
						nc += dc[nd];
						ns--;
					}
					f.c = nc;
				}
				f.d = nd;

			} // 상어 이동
			Collections.sort(fish);
	
			int nr=-1, nc=-1;
			for (Iterator<Fish> iter = fish.iterator(); iter.hasNext();) {
				Fish f = iter.next();
				if(nr==f.r && nc==f.c)
					iter.remove();
				
				nr=f.r;
				nc=f.c;
			}

		} // 사람 이동

		System.out.println(sum);
		br.close();
	}

}
