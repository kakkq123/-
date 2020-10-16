import java.io.*;
import java.util.*;

public class Main {
	static int answer = 0;
	//윷놀이판
	static int[][] map = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
			{ 10, 13, 16, 19, 25, 30, 35, 40 }, { 20, 22, 24, 25, 30, 35, 40 }, { 30, 28, 27, 26, 25, 30, 35, 40 } };
	//각 위치의 넘버링
	static int[][] number = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
			{ 5, 21, 22, 23, 29, 30, 31, 20 }, { 10, 24, 25, 29, 30, 31, 20  }, { 15, 26, 27, 28, 29, 30, 31, 20 } };
	//명령어들 저장
	static int[] command = new int[10];
	//말들이 있는지 체크
	static boolean[] check = new boolean[32];
	//현재 말들의 위치
	static int[][] here = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++)
			command[i] = Integer.parseInt(st.nextToken());
		br.close();
		dfs(0, 0);
		bw.write(answer + "\n");
		bw.close();

	}

	private static void dfs(int cn, int score) {
		//모든 명령어 수행
		if (cn == 10) {
			answer = Math.max(answer, score);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 이 말은 이동할 수가 없음
			if (here[i][0] == -1)
				continue;

			int _x = here[i][0], x = here[i][0], _y = here[i][1], y = here[i][1];
			y += command[cn];

			// 도착
			if (y >= map[x].length) {
				int before = number[_x][_y];
				check[before] = false;
				here[i][0] = -1;
				dfs(cn + 1, score);
				check[before] = true;
				here[i][0] = _x;
			}
			// 도착 X
			else {
				// 파란칸이면
				if (x == 0 && y == 5) {
					x = 1;
					y = 0;
				} else if (x == 0 && y == 10) {
					x = 2;
					y = 0;
				} else if (x == 0 && y == 15) {
					x = 3;
					y = 0;
				}

				int before = number[_x][_y];
				int after = number[x][y];
				// 다른 말이 있다면 이동 못함
				if (check[after])
					continue;

				check[after] = true;
				check[before] = false;
				here[i][0] = x;
				here[i][1] = y;

				dfs(cn + 1, score + map[x][y]);

				check[after] = false;
				check[before] = true;
				here[i][0] = _x;
				here[i][1] = _y;
			}
		}

	}


}
