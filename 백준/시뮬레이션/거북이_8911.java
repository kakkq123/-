import java.io.*;

public class Main {
	static int[] dy = { 1, 0, -1, 0 }, dx = { 0, 1, 0, -1 };

	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int mx = 0, my = 0, lx = 0, ly = 0, dir = 0, x = 0, y = 0;
			char c;
			for (int j = 0; j < s.length(); j++) {
				c = s.charAt(j);
				//앞으로
				if (c == 'F') {
					x += dx[dir];
					y += dy[dir];
				}
				//후진
				else if (c == 'B') {
					x -= dx[dir];
					y -= dy[dir];
				}
				//왼쪽으로 방향 틀기
				else if (c == 'L') {
					dir = (dir + 3) % 4;
				}
				//오른쪽으로 방향 틀기
				else {
					dir = (dir + 1) % 4;
				}
				//x,y 좌표의 최댓값,최솟값 갱신
				mx = Math.max(mx, x);
				my = Math.max(my, y);
				lx = Math.min(lx, x);
				ly = Math.min(ly, y);
			}
			//가장 작은 직사각형 구하기
			int X = mx - lx;
			int Y = my - ly;
			bw.write((X * Y) + "\n");
		}
		br.close();
		bw.close();
	}

}
