class Solution {
    public int solution(int[] budgets, int M) {
        int max = 0, min = 0, answer = 0;
        for(int i = 0; i < budgets.length; i++)
            max = Math.max(max, budgets[i]);
        while(min <= max){
            int mid = (min + max) / 2;
            long sum = 0;
            for(int i = 0; i < budgets.length; i++){
                if(budgets[i] < mid)
                    sum += budgets[i];
                else
                    sum += mid;       
            }
            //
            if(sum > M){
                max = mid - 1;
            }else{
                answer = mid;
                min = mid + 1;
            }
        }
        return answer;
    }
}
