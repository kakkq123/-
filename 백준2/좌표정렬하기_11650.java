import java.io.*;
import java.util.*;

public class 좌표정렬하기_11650 {

	static class Pos implements Comparable<Pos> {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pos p) {
			if (this.x == p.x)
				return this.y < p.y ? -1 : 1;
			return this.x < p.x ? -1 : 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			q.add(new Pos(x, y));
		}
		br.close();
		
		while(!q.isEmpty()) {
			int x = q.peek().x, y = q.peek().y;
			q.poll();
			bw.write(x+" "+y+"\n");
			bw.flush();
		}	
		bw.close();
	}

}
