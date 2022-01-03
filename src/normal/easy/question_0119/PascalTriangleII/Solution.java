package normal.easy.question_0119.PascalTriangleII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jungle
 * @since 2021/8/1 00:04
 */
public class Solution {
    @Test
    public void test() {
        System.out.println(getRow(3));
    }
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        triangle.add(first);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> out = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    out.add(1);
                } else {
                    out.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(out);
        }
        return triangle.get(rowIndex);
    }
}
