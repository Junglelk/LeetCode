package competition_5830.ThreeDivisors;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
 *
 * @author Jungle
 * @since 2021/8/1 10:30
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(isThree(4));
    }


    public boolean isThree(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(n);
        if (n >= 2) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    set.add(i);
                }
            }
        }

        return set.size() == 3;
    }
}
