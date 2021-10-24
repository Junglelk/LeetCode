import org.junit.Test;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
        System.out.println(countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
        System.out.println(countValidWords("fzdej0s mss!v  u.0!  3c,i!,h3p63 nk   ipyz-9 - vn1 vk50u"));
        System.out.println(countValidWords("vn1"));
        System.out.println(countValidWords(". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5"));
//        System.out.println(nextBeautifulNumber(748601));
    }

    /**
     * 仅由小写字母、连字符和/或标点（不含数字）。
     * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
     * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
     *
     * @param sentence
     * @return
     */
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        String rex = "^[a-z]+$|^[a-z]+-?[a-z]+$|[a-z]*[.,!]?$|^[a-z]+-?[a-z]+[,!.]?$";
        int nums = 0;
        for (String word : words) {
            if ("".equals(word)) {
                continue;
            }
            if (word.matches(rex)) {
                nums++;
            }
        }
        return nums;
    }

}
