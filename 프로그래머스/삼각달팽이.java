class Solution {
    public int[] solution(int n) {
        int[][] a= new int[n][n];
        int[] answer = new int[getSize(n)];
        int[] dr = {1,0,-1}, dc = {0,1,-1};
        
        //달팽이는 아래, 오른쪽, 대각선순으로 n, n - 1, n - 2, ... 1칸씩 움직인다.
        int move = n, dir = 0, r = -1, c = 0, num = 1;
        while(move > 0){
            //move만큼 움직임
            for(int i = 0; i < move; i++){
                r += dr[dir];
                c += dc[dir];
                a[r][c] = num++;
            }
            //방향을 바꿈
            dir = (dir + 1) % 3;
            // 다음엔 -1칸 덜 움직임
            move--;
        }
             
        //answer에 결과 저장
        int idx = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<=i; j++)
                answer[idx++] = a[i][j];
        return answer;
    }
    
    private int getSize(int n){
        return ((1 + n) * n ) / 2;
    }
}
