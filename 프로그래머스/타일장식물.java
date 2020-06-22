class Solution {
    public long solution(int N) {
        long[] dp = new long[N + 1];
        dp[1] = 4;
        if(N > 1){
            dp[2] = 6;
            for(int i = 3; i <= N; i++)
                dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[N];
    }
}
