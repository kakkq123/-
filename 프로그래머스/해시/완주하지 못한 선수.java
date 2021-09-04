import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> nameList = new HashMap<String, Integer>();
        for(int i = 0; i < participant.length; i++){
            String key = participant[i];
            if(nameList.containsKey(key)){
                nameList.put(key, nameList.get(key) + 1);
            }else{
                nameList.put(key, 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++){
            String key = completion[i];
            if(nameList.containsKey(key)){
                if(nameList.get(key) == 1){
                    nameList.remove(key);
                }else{
                    nameList.put(key, nameList.get(key) - 1);
                }
            }
        }
        String answer = "";
        for(String name: nameList.keySet()){
            answer = name;
        }
        return answer;
    }
}
