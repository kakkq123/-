class Solution {
    static boolean[] visit;
    
    public void dfs(int index, int n, int[][] computers){
        for(int i = 0; i < n; i++){
            if(!visit[i] && computers[index][i] == 1){
                visit[i] = true;
                dfs(i, n, computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                answer++;
                dfs(i, n, computers);
            }
        }
        return answer;
    }
}
