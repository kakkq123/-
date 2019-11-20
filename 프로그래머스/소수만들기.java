class Solution {
    static int answer = 0;
    
    public void solve(int index, int n, int sum,int[] nums){
        if(n == 3){
            boolean check = true;
            for(int i = 2; i < sum / 2; i++){
                if(sum % i == 0){
                    check = false;
                    break;
                }
            }
            if(check)
                answer++;
            return;
        }
        if(index == nums.length)
            return;
            
        solve(index + 1, n + 1, sum + nums[index], nums);
        solve(index + 1, n, sum , nums);
            
    }
    public int solution(int[] nums) {
        solve(0, 0, 0 , nums);
        return answer;
    }
}
