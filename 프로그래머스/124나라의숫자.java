class Solution {
    public String solution(int n) {
        String answer = "";
        int q=n,r;
        while(q != 0){
            r = q % 3;
            q = q / 3;
            if(r == 0){
                q--;
                answer = "4"+answer; 
            }
            else
                answer = Integer.toString(r)+answer;
        }
        
       
        return answer;
  }
}
