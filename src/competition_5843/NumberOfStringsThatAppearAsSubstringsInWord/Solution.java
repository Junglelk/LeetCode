package competition_5843.NumberOfStringsThatAppearAsSubstringsInWord;

import org.junit.Test;

/**
 * @author Jungle
 * @since 2021/8/15 10:32
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(numOfStrings(new String[]{"a","b","c"},"aaaaaabbbbbbb"));
    }



    public int numOfStrings(String[] patterns, String word) {
        int nums = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                nums++;
            }
        }
        return nums;
    }
}
