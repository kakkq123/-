class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0 ; i < skill_trees.length; i++){
            boolean check = true;
            String cmp = skill;
            String[] s = skill_trees[i].split("");
            for(int j = 0 ; j < s.length; j++){
                if(!cmp.contains(s[j]) || cmp.equals(""))
                    continue;
                if(cmp.substring(0,1).equals(s[j])){
                    cmp = cmp.substring(1);
                    continue;
                }else{
                    check = false;
                    break;
                }
            }
            if(check)
                answer++;
        }
        return answer;
    }
}
