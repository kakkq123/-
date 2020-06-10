class Solution {
    static boolean[][] visited;
    static int[][] p;
    static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};
    static int cnt = 1;

  public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0, maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        p = new int[m][n];
        p = picture;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    visited[i][j] = true;
                    dfs(i,j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    cnt = 1;
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
      return answer;
  }
    public static void dfs(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(nx < 0 || nx >= p.length || ny < 0 || ny >= p[0].length)
                continue;
            if(!visited[nx][ny] && p[x][y] == p[nx][ny] && p[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    cnt++;
                    dfs(nx,ny);
            }  
        }
    }
}
