package normal.difficult.question_0458.PoorPigs;

/**
 * There are 'buckets' buckets of liquid, where exactly one of the buckets is poisonous. To figure out which one is poisonous, you feed some number of (poor) pigs the liquid to see whether they will die or not. Unfortunately, you only have minutesToTest minutes to determine which bucket is poisonous.
 * <p>
 * You can feed the pigs according to these steps:
 * <pre>
 * Choose some live pigs to feed.
 * For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will take no time.
 * Wait for minutesToDie minutes. You may not feed any other pigs during this time.
 * After minutesToDie minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.
 * Repeat this process until you run out of time.
 * </pre>
 * Given buckets, minutesToDie, and minutesToTest, return the minimum number of pigs needed to figure out which bucket is poisonous within the allotted time.
 * <p>
 * 有 buckets 桶液体，其中 正好 有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。
 * <p>
 * 为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。不幸的是，你只有 minutesToTest 分钟时间来确定哪桶液体是有毒的。
 * <p>
 * 喂猪的规则如下：
 * <pre>
 * 选择若干活猪进行喂养
 * 可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
 * 小猪喝完水后，必须有 minutesToDie 分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。
 * 过了 minutesToDie 分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
 * 重复这一过程，直到时间用完。
 * 给你桶的数目 buckets ，minutesToDie 和 minutesToTest ，返回在规定时间内判断哪个桶有毒所需的 最小 猪数。
 *  </pre>
 * <pre>
 * 输入：buckets = 1000, minutesToDie = 15, minutesToTest = 60
 * 输出：5
 *  </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/poor-pigs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/25 20:51
 */
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int k = minutesToTest / minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(k + 1));
    }
}
