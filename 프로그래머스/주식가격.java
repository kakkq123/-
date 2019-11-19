class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        boolean[] check = new boolean[prices.length];
        for(int i = 0; i < prices.length - 1; i++){
            for(int j= i+1; j < prices.length; j++){
                answer[i]++;
                if(prices[j] < prices[i])
                    break;
            }
        }
        return answer;
    }
}
