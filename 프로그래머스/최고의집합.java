class Solution {
    public int[] solution(int n, int s) {
        if(n > s)
            return new int[] {-1};
        int[] answer = new int[n];
        int q = s / n, r = s % n, i = 0;
        while(i < n - r){
            answer[i] = q;
            i++;
        }
        while(i < n){
            answer[i] = q + 1;
            i++;
        }
        return answer;
    }
}
