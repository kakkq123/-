import java.io.*;
import java.util.*;

public class Main {
	static class Robot {
		boolean live;
		int durability;

		public Robot(int durability, boolean live) {
			this.durability = durability;
			this.live = live;
		}
	}

	static public void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int len = N * 2;
		Robot[] a = new Robot[len + 1];
		for (int i = 1; i <= len; i++) {
			int d = Integer.parseInt(st.nextToken());
			a[i] = new Robot(d, false);
		}
		br.close();
		
		int stop = 0, step = 0;

		while (stop < K) {
			//컨테이너 이동
			int _d = a[len].durability;
			boolean _l = a[len].live;
			for (int i = len; i > 1; i--) {
				a[i].durability = a[i - 1].durability;
				a[i].live = a[i - 1].live;
			}
			a[1].durability = _d;
			a[1].live = _l;

			//컨테이너가 이동해서 N번의 위치에 로봇이 왔다면 내려야함
			if (a[N].live)
				a[N].live = false;

			//로봇을 순서대로 이동시켜줌
			for (int i = N - 1; i >= 1; i--) {
				if (a[i].live) {
					//로봇이 다음칸 이동 가능하다면
					if (a[i + 1].durability > 0 && a[i + 1].live == false) {
						a[i].live = false;
						if (--a[i + 1].durability == 0)
							stop++;
						if (i + 1 < N)
							a[i + 1].live = true;
					}
				}
			}
			//1번 위치에 로봇을 올릴 수 있다면 올린다
			if (a[1].durability > 0 && a[1].live == false) {
				if (--a[1].durability == 0)
					stop++;
				a[1].live = true;
			}
			step++;

		}
		bw.write(step+"\n");
		bw.close();
	}

}
