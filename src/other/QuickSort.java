package other;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jungle
 * @since 2021/11/19 22:19
 */
public class QuickSort {
    @Test
    public void test() {
        int[] ary = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(ary);
        System.out.println(Arrays.toString(ary));
    }

    public static void quickSort(int[] ary) {
        quickSort(ary, 0, ary.length - 1);
    }

    public static void quickSort(int[] ary, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(ary, lo, hi);
        //处理左侧
        quickSort(ary, lo, j - 1);
        // 处理右侧
        quickSort(ary, j + 1, hi);
    }

    public static int partition(int[] ary, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int p = ary[lo];
        while (true) {
            // 从左往右遍历，当遇到大于p的元素时，循环结束,保留下标i；
            while (p > ary[++i]) {
                if (i == hi) {
                    break;
                }
            }
            while (p < ary[--j]) {
                // 从右往左遍历，当遇到小于p的元素时，循环结束，保留下标j。
                if (j == lo) {
                    break;
                }
            }
            // 如果全程无大小关系，则走到两端时退出循环
            //i与j相遇，切分完成，退出循环
            if (i >= j) {
                break;
            }
            //否则交换i j位置处的元素
            int temp = ary[i];
            ary[i] = ary[j];
            ary[j] = temp;
        }
        //上述循环结束后，lo仍为起始位置，j所在位置所指的数据为从右向左数，第一个小于中枢的数据（即中枢位置）
        // 即，j位置处的数据应为小于右边，大于左边
        // 所以要将j与中枢数据的下标位置交换，将中枢数据换到应有的下标处
        int temp = ary[lo];
        ary[lo] = ary[j];
        ary[j] = temp;
        return j;
    }
}