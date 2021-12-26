package normal.easy.question_1078.OccurrencesAfterBigram;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
 * <p>
 * Return an array of all the words third for each occurrence of "first second third".
 * <p>
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/26 15:27
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] texts = text.split(" ");
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < texts.length - 2; i++) {
            if (texts[i].equals(first) && texts[i + 1].equals(second)) {
                ret.add(texts[i + 2]);
            }
        }
        return ret.toArray(new String[]{});
    }
}
