class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int r, c;
        for(int i=1; i<=red; i++){
            if(red % i == 0){
                r = i;
                c = red / i;
                if((r + 2) * (c + 2) - red == brown){
                    answer[0] = Math.max(r + 2, c + 2);
                    answer[1] = Math.min(r + 2, c + 2);
                }
                
            }
        }
        return answer;
    }
}
