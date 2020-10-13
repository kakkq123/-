import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static char[][] map;
	static boolean[][] visit, check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C]; // 미로 문자
		visit = new boolean[R][C]; // 방문 체크
		check = new boolean[R][C]; // 탈출 여부를 저장
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = s.charAt(j);
		}
		br.close();
		//방문하지 않는 곳이 있다면 dfs를 호출
		for (int r = R - 1; r >= 0; r--) {
			for (int c = 0; c < C; c++) {
				if (!visit[r][c]) {
					visit[r][c] = true;
					check[r][c] = dfs(r, c);
				}
			}
		}
		//check가 true이면 탈출 가능한 칸
		int cnt = 0;
		for (int r = 0; r < R; r++)
			for (int c = 0; c < C; c++)
				if (check[r][c])
					cnt++;

		bw.write(cnt + "\n");
		bw.close();
	}

	private static boolean dfs(int r, int c) {
		//미로에 있는 명령어에 따라 칸을 이동~
		if (map[r][c] == 'U') {
			r += dr[0];
			c += dc[0];
		} else if (map[r][c] == 'D') {
			r += dr[1];
			c += dc[1];
		} else if (map[r][c] == 'R') {
			r += dr[2];
			c += dc[2];
		} else {
			r += dr[3];
			c += dc[3];
		}
		//칸을 벗어나면 탈출 가능
		if (r < 0 || r >= R || c < 0 || c >= C)
			return true;
		//방문했던 곳이라면 check를 return해줌
		//**탈출하지 못하고 빙빙 돌고 있다면 false를 return
		//**탈출 가능했던 칸이었다면 true를 return 
		if (visit[r][c])
			return check[r][c];
		//방문했다고 표시
		visit[r][c] = true;
		//dfs가 반환되면서 이 칸은 탈출 가능한지 아닌지 check에 결과값 반영해줌
		return check[r][c] = dfs(r, c);
	}

}
