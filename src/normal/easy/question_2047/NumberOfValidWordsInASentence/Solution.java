package normal.easy.question_2047.NumberOfValidWordsInASentence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Jungle
 * @since 2022/1/27 10:57
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(countValidWords("cat and  dog"));
    }
    public int countValidWords(String sentence) {
        return (int) Arrays.stream(sentence.split(" "))
                .filter(s -> !"".equals(s))
                .filter(s -> s.matches("^[a-z]+$|^[a-z]+-?[a-z]+$|[a-z]*[.,!]?[0-9]{0}$|^[a-z]+-?[a-z]+[,!.]?$"))
                .count();
    }
}
