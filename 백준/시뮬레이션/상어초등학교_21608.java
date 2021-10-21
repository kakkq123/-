import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2 {

	static int N, M, answer = 0;
	static int[][] seat;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static Set[] friends;
	static PriorityQueue<Friend> q = new PriorityQueue<Friend>();

	static class Friend implements Comparable<Friend> {
		int friends, blank, r, c;

		public Friend(int friends, int blank, int r, int c) {
			this.friends = friends;
			this.blank = blank;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Friend f) {
			if (this.friends == f.friends) {
				if (this.blank == f.blank) {
					if (this.r == f.r)
						return this.c - f.c;
					return this.r - f.r;
				}
				return f.blank - this.blank;
			}
			return f.friends - this.friends;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		seat = new int[N][N];
		M = N * N;
		friends = new HashSet[M + 1]; // 해당 학생이 같이 앉고 싶어하는 친구 목록
		for (int i = 1; i <= M; i++)
			friends[i] = new HashSet<Integer>();

		int[] student = new int[M + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			student[i + 1] = num;
			for (int j = 0; j < 4; j++) {
				int f = Integer.parseInt(st.nextToken());
				friends[num].add(f);
			}
		}

		// 학생들 좌석 찾아주기
		for (int i = 1; i <= M; i++) {
			q = new PriorityQueue<Friend>();
			findSeat(student[i]);
			Friend f = q.poll();
			seat[f.r][f.c] = student[i];
		}

		// 만족도 조사
		int sum = getScore();
		System.out.println(sum);
	}

	private static int getScore() {
		int score = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int student = seat[i][j], cnt = 0;
				for (int d = 0; d < 4; d++) {
					int r = i + dr[d];
					int c = j + dc[d];
					if (r < 0 || r >= N || c < 0 || c >= N)
						continue;
					if (friends[student].contains(seat[r][c]))
						cnt++;
				}
				if (cnt == 1)
					score += 1;
				if (cnt == 2)
					score += 10;
				if (cnt == 3)
					score += 100;
				if (cnt == 4)
					score += 1000;
			}
		}
		return score;
	}

	private static void findSeat(int student) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 빈자리가 존재한다면
				if (seat[i][j] == 0) {
					int b = 0, f = 0;
					// 주변에 빈칸과 좋아하는 친구 찾기
					for (int d = 0; d < 4; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						if (r < 0 || r >= N || c < 0 || c >= N)
							continue;
						if (seat[r][c] == 0)
							b++;
						if (friends[student].contains(seat[r][c]))
							f++;
					}
					q.add(new Friend(f, b, i, j));
				}
			}
		}

	}

}
