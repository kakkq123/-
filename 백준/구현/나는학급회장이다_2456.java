import java.io.*;
import java.util.*;

public class Main {

	static class President implements Comparable<President> {
		int num, score1, score2, score3, sum;

		public President(int num) {
			this.num = num;
			this.score1 = 0;
			this.score2 = 0;
			this.score3 = 0;
			this.sum = 0;
		}

		public int compareTo(President p) {
			if (this.sum == p.sum) {
				if (this.score3 == p.score3)
					return p.score2 - this.score2;
				return p.score3 - this.score3;
			}
			return p.sum - this.sum;
		}
	}

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		President[] p = new President[4]; //후보들의 정보를 저장
		for (int i = 1; i <= 3; i++)
			p[i] = new President(i);

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] num = new int[4];
			for (int j = 1; j <= 3; j++)
				num[j] = Integer.parseInt(st.nextToken());
			//해당 점수를 받으면 score개수를 증가시켜주고, 총합도 갱신해줌
			for (int j = 1; j <= 3; j++) {
				if (num[j] == 1) {
					p[j].score1++;
				} else if (num[j] == 2) {
					p[j].score2++;
				} else {
					p[j].score3++;
				}
				p[j].sum += num[j];
			}
		}
		br.close();
		
		//우선순위큐에 저장하여 정렬해줌
		PriorityQueue<President> q = new PriorityQueue<President>();
		for (int i = 1; i <= 3; i++)
			q.add(p[i]);

		President pre = q.poll();
		//동점자가 있다면 후보를 고를 수 없음
		if (pre.sum == q.peek().sum && pre.score3 == q.peek().score3 && pre.score2 == q.peek().score2)
			bw.write("0 " + pre.sum + "\n");
		else
			bw.write(pre.num + " " + pre.sum + "\n");

		bw.close();
	}

}
