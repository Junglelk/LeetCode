package interview.ch01.question_08.ZeroMatrix;

import java.util.*;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * <p>
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * <pre>
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/02/01 18:29
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    map.put(i, list);
                }
            }
        }
        // 处理行
        for (int i = 0; i < matrix.length; i++) {
            if (map.containsKey(i)) {
                Arrays.fill(matrix[i], 0);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Integer row : map.keySet()) {
            List<Integer> list = map.get(row);
            set.addAll(list);
        }
        // 处理列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (set.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
