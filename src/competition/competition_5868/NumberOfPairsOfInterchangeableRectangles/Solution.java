package competition.competition_5868.NumberOfPairsOfInterchangeableRectangles;

import org.junit.Test;

import java.util.Arrays;

/**
 * 用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
 * <p>
 * 如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
 * <p>
 * 计算并返回 rectangles 中有多少对 可互换 矩形。
 * <pre>
 * 输入：rectangles = [[4,8],[3,6],[10,20],[15,30]]
 * 输出：6
 * 解释：下面按下标（从 0 开始）列出可互换矩形的配对情况：
 * - 矩形 0 和矩形 1 ：4/8 == 3/6
 * - 矩形 0 和矩形 2 ：4/8 == 10/20
 * - 矩形 0 和矩形 3 ：4/8 == 15/30
 * - 矩形 1 和矩形 2 ：3/6 == 10/20
 * - 矩形 1 和矩形 3 ：3/6 == 15/30
 * - 矩形 2 和矩形 3 ：10/20 == 15/30
 * </pre>
 * <pre>
 * 输入：rectangles = [[4,5],[7,8]]
 * 输出：0
 * 解释：不存在成对的可互换矩形。
 * </pre>
 * <pre>
 * n == rectangles.length
 * 1 <= n <= 10^5
 * rectangles[i].length == 2
 * 1 <= widthi, heighti <= 10^5
 * </pre>
 *
 * @author Jungle
 * @since 2021/9/12 10:38
 */
public class Solution {

    @Test
    public void test() {
//        System.out.println(interchangeableRectangles(new int[][]{{4, 8}, {1, 15}, {10, 20}, {2, 30}}));
        System.out.println(interchangeableRectangles(new int[][]{{4, 5}, {7, 8}}));
    }


    public long interchangeableRectangles(int[][] rectangles) {
        double[] ret = new double[rectangles.length];
        int i = 0;
        for (int[] rectangle : rectangles) {
            ret[i++] = (double) rectangle[0] / rectangle[1];
        }
        long nums = 0L;
        Arrays.sort(ret);
        double temp = ret[0];
        long a = 1L;
        for (int j = 1; j < ret.length; j++) {
            if (temp == ret[j]) {
                a++;
            } else {
                temp = ret[j];
                if (a != 1) {
                    nums += (a * (a - 1)) / 2;
                    a = 1;
                }
            }
        }
        nums += (a * (a - 1)) / 2;
        return nums;
    }
}
