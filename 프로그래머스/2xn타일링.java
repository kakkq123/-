class Solution {
    static int[] dp = new int[60001];
    
    public int dfs(int n){
        if(n == 1)
            return dp[1] = 1;
        if(n == 2)
            return dp[2] = 2;
        if(dp[n]!= 0)
            return dp[n];
        return dp[n] = (dfs(n - 1) + dfs(n - 2))%1000000007;
    }
    public int solution(int n) {
        dfs(n);
        return dp[n];
    }
}
