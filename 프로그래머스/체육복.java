class Solution {
    static int[] student;
    static int answer = 0;
    public void solve(int index, int n){
        if(index == n){
            int sum = 0;
            for(int i=1; i<=n; i++)
                if(student[i] != -1)
                    sum++;
            if(sum > answer)
                answer = sum;
            return;
        }
        if(student[index] == -1){
            if(index > 1 && student[index - 1] == 1){
                student[index - 1] = 0;
                student[index] = 0;
                solve(index + 1, n);
                student[index - 1] = 1;
                student[index] = -1;
            }
            if(index < n && student[index + 1] == 1){
                student[index + 1] = 0;
                student[index] = 0;
                solve(index + 1, n);
                student[index + 1] = 1;
                student[index] = -1;
            }
        }
		solve(index+1, n);
        
    }
    public int solution(int n, int[] lost, int[] reserve) {
        student = new int[n+1];
        for(int i = 0; i < reserve.length; i++)
            student[reserve[i]] ++;
        for(int i = 0; i < lost.length; i++)
                student[lost[i]] --;
       
        solve(1, n);
        return answer;
    }
}
