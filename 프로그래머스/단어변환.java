class Solution {
    static int answer;
    public void dfs(int cnt, String begin, String target, String[] words){
        if(cnt >= answer)
            return;
        if(begin.equals(target)){
            answer = cnt;
            return;
        }
        int t;
        for(int i = 0; i < words.length; i++){
            t = 0;
            for(int j = 0; j < words[i].length(); j++){
                if(begin.charAt(j) != words[i].charAt(j))
                    t++;
            }
            if(t == 1)
                dfs(cnt + 1, words[i], target, words);
        }
    }
    public int solution(String begin, String target, String[] words) {
        answer = words.length + 1;
        dfs(0, begin, target, words);
        if(answer == words.length + 1)
            answer = 0;
        return answer;
    }
}
