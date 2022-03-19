package normal.easy.question_0069.Sqrtx;

import org.junit.jupiter.api.Test;

/**
 * @author Jungle
 * @since 2021/7/9 23:56
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(mySqrt(21.0));
    }

    public double mySqrt(double x) {
        double ans = 0.0;
        double right = x, left = 0.0;
        while (left <= right) {
            double middle = (right + left) / 2;
            if (middle * middle <= x) {
                ans = middle;
                left = middle + 0.000000001;
            } else {
                right = middle - 0.000000001;
            }
        }
        return ans;
    }
}
