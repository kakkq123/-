class Solution {
   public boolean range(int x, int y) {
		return x >= -5 && x <= 5 && y >= -5 && y <= 5;
	}
    public int solution(String dirs) {
		int answer = 0, x = 0, y = 0, dir;
		String[] sa = dirs.split("");
		int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
		boolean[][][][] visit = new boolean[12][12][12][12];

		for (int i = 0; i < sa.length; i++) {
			if (sa[i].equals("U"))
				dir = 0;
			else if (sa[i].equals("R"))
				dir = 1;
			else if (sa[i].equals("D"))
				dir = 2;
			else
				dir = 3;
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (range(nx, ny)) {
				if(!visit[x + 5][y + 5][nx + 5][ny + 5])
					answer++;
				visit[x + 5][y + 5][nx + 5][ny + 5]= true;
				visit[nx + 5][ny + 5][x + 5][y + 5]= true;
				x = nx; y = ny;
			}
		}
		return answer;
    }
}
