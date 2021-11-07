package competition_5918.CountVowelSubstrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jungle
 * @since 2021/11/7 11:20
 */
public class Solution {
    public int countVowelSubstrings(String word) {
        HashSet<Character> set = new HashSet<>();
        set.add('i');
        set.add('a');
        set.add('e');
        set.add('o');
        set.add('u');
        int num = 0;
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < word.length() - 5; i++) {
            String temp = word.substring(i, i + 5);
            boolean is = false;
            Set<Character> tempSet = (Set<Character>) set.clone();
            for (int j = 0; j < temp.length(); j++) {
                if (tempSet.contains(temp.charAt(j))) {
                    tempSet.remove(temp.charAt(j));
                    is = true;
                } else {
                    is = false;
                    break;
                }
            }
            if (is) {

                points.add(i);
            }
        }

        for (Integer point : points) {
            num++;
            int before = 0;
            int after = 0;
            for (int i = point - 1; i > 0; i--) {
                if (set.contains(word.charAt(i))) {
                    before++;
                } else {
                    break;
                }
            }
            for (int i = point + 5; i < word.length(); i++) {
                if (set.contains(word.charAt(i))) {
                    after++;
                } else {
                    break;
                }
            }
            int temp = after + before;
            int mul = 1;
            while (temp != 0) {
                mul *= temp;
                temp--;
            }
            if (mul == 0) {
                num++;
            } else {
                num += mul;
            }
        }

        if (word.length() == 5) {
            boolean is = false;
            for (int j = 0; j < word.length(); j++) {
                if (set.contains(word.charAt(j))) {
                    is = true;
                    set.remove(word.charAt(j));
                } else {
                    is = false;
                    break;
                }
            }
            if (is) {
                num++;
            }
        }
        return num;
    }
}
