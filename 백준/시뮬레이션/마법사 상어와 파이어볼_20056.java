import java.io.*;
import java.util.*;
/**
 * 문제를 잘 읽자
 * 초기화를 잘 해주자
 * **/
public class Main {
	static int N, M, K;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static LinkedList<FireBall>[][] map;

	static class FireBall {
		int m, s, d;

		public FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<FireBall>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new FireBall(m, s, d));
		}

		solve();

		long sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                for(FireBall fb : map[i][j])
                    sum += fb.m;
            }
        }
        
		bw.write(sum + "\n");
		br.close();
		bw.close();
	}

	private static void solve() {
		for (int k = 0; k < K; k++) {
			// 파이어볼 이동
			moveFireBall();
			// 파이어볼 분리
			divideFireBall();
		}

	}

	private static void moveFireBall() {
		LinkedList<FireBall>[][] next = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				next[i][j] = new LinkedList<FireBall>();
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (FireBall f : map[r][c]) {
					int s = f.s % N;
					int d = f.d;

					int nr = r + dr[d] * s;
					int nc = c + dc[d] * s;
					if (nr < 0)
						nr += N;
					if (nr >= N)
						nr -= N;
					if (nc < 0)
						nc += N;
					if (nc >= N)
						nc -= N;

					next[nr][nc].add(new FireBall(f.m, f.s, f.d));
				}
			}
		}

		map = next;

	}

	private static void divideFireBall() {
	

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c].size() >= 2) {
					int sumM = 0, sumS = 0, size = map[r][c].size();
					boolean flag = true;
					int dir = map[r][c].get(0).d;

					for (FireBall f : map[r][c]) {
						sumM += f.m;
						sumS += f.s;
						if (flag && (dir + f.d) % 2 == 1) {
							flag = false;
						}
					}
					// 질량이 0이 아니라면
					int nm = sumM / 5, ns = sumS / size;
					map[r][c].clear();
					if (nm > 0) {
						// 방향은 0, 2, 4, 6						
						if (flag) {
							for (int d = 0; d < 7; d += 2) {
								map[r][c].add(new FireBall(nm, ns, d));
							}
						}
						// 방향은 1, 3, 5, 7
						else {
							for (int d = 1; d < 8; d += 2) {
								map[r][c].add(new FireBall(nm, ns, d));
							}
						}
					}

				}
			}
		} // end of for


	}

}
