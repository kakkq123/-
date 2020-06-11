import java.util.*;

class Solution {
    static int MOD = 20170805;
   
    public int solution(int m, int n, int[][] cityMap) {
        int[][] d = new int[m + 1][n + 1], r = new int[m + 1][n + 1];
        d[1][1] = 1;
        r[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(cityMap[i-1][j-1] == 0){
                    d[i][j] += (d[i - 1][j] + r[i][j - 1]) % MOD;
                    r[i][j] += (d[i - 1][j] + r[i][j - 1]) % MOD;
                }else if(cityMap[i-1][j-1] == 1){
                    d[i][j] = 0;
                    r[i][j] = 0;
                }else{
                    d[i][j] += d[i - 1][j];
                    r[i][j] += r[i][j - 1];
                }
            }
        }
        int answer = d[m][n];
        return answer;
    }
}
