import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int max_num=citations[citations.length-1];
        for(int i=1; i<=max_num; i++){
            int count=0;
            for(int j=citations.length-1; j>=0; j--){
                if(i<=citations[j])
                    count++;
                else
                    break;
            }
            if(count>=i && citations.length-count<=i ){
                answer=i;
            }
        }
        return answer;
    }
}
