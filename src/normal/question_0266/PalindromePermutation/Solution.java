package normal.question_0266.PalindromePermutation;

import java.util.HashMap;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s.equals("")||s.length()==1)
            return true;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <n; i++) {
            char temp = s.charAt(i);
            if (!map.containsKey(temp)){
                map.put(temp,1);
            }else
                map.remove(temp);
        }
        if (map.size()==0||map.size()==1)
            return true;
        else
            return false;
    }
}
