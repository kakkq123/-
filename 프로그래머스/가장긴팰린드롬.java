class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int d = 0; d < s.length(); d++){
            for(int i = 0; i + d < s.length(); i++){
                if(d == 0)
                    dp[i][i] = true;
                else if(d == 1 && s.charAt(i) == s.charAt(i + 1)){
                    dp[i][i + 1] = true;
                    answer = 2;
                }
                else{
                    dp[i][i + d] = dp[i + 1][i + d - 1] && s.charAt(i) == s.charAt(i + d);
                    if(dp[i][i + d]) answer = d + 1;
                }
            }
        }

        return answer;
    }
}
