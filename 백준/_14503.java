import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14503 {
	static int n, m, cnt = 0;
	static int[][] board;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	
	public static void clean(int r, int c) {
		board[r][c]=2;
		cnt++;
	}
	
	public static int rotate(int d) {
		return (d+3)%4;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int num=0;
		// 0 북 , 1 동, 2 남, 3서
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r,c);  // 1
		while(true) {
			d=rotate(d);
			num++;
			if(board[r+dy[d]][c+dx[d]]==0) {
				r=r+dy[d];
				c=c+dx[d];
				clean(r,c);  // 1
				num=0;
				continue;
			}
			if(num>=4) {
				if(board[r-dy[d]][c-dx[d]]==1)
					break;
				r=r-dy[d];
				c=c-dx[d];
				num=0;
			}
		}

		System.out.println(cnt);
		br.close();
	}

}
