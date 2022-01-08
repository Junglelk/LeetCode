package normal.medium.question_0089.GrayCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * An n-bit gray code sequence is a sequence of 2n integers where:
 * <pre>
 * Every integer is in the inclusive range [0, 2n - 1],
 * The first integer is 0,
 * An integer appears no more than once in the sequence,
 * The binary representation of every pair of adjacent integers differs by exactly one bit, and
 * The binary representation of the first and last integers differs by exactly one bit.
 * </pre>
 * Given an integer n, return any valid n-bit gray code sequence.
 *
 * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
 * <pre>
 * 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
 * 第一个整数是 0
 * 一个整数在序列中出现 不超过一次
 * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
 * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
 * </pre>
 * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gray-code
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Jungle
 * @since 2022/1/8 10:26
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(grayCode(5));
    }



    /**
     * 这道题我一开始的想法是挨个做校验，第一位显然为 0 那第二位只能是 1 、2 、4 等 2 的整数次幂的情况，
     *
     * 但显然这样的效率极低，问题是，我为什么会想起这种解决方案呢？仅仅是因为我没听过格雷码？我想不是。原因多做点儿题可能就清楚了
     * @param n 生成格雷码的原始值
     * @return 格雷码列表
     */
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1<< n; i++) {
            list.add((i >> 1) ^ i);
        }
        return list;
    }
}
