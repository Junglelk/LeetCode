package normal.medium.question_0386.LexicographicalNumbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
 * <p>
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space. 
 * <p>
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * <p>
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * <pre>
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/lexicographical-numbers">https://leetcode-cn.com/problems/lexicographical-numbers</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/4/18 22:39
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(lexicalOrder(10));
    }

    /**
     * 显然需要插入 n 次，且无需排序。循环 n 次实现 n 次插入，边界对边界条件进行判断保证不会越界。
     *
     * @param n 目标值
     * @return 列表
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int number = 1;
        // 控制添加次数
        for (int i = 0; i < n; i++) {
            // 每次循环只添加一次，保证数量对得上
            list.add(number);
            if (number * 10 <= n) {
                // 保证字典序的起始值
                number *= 10;
            } else {
                // 保证不会越界
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return list;
    }
}
