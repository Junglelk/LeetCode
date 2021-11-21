import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
//        System.out.println(maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1}));
        // [3,2,4,2,1]
        //6
//        System.out.println(wateringPlants(new int[]{3, 2, 4, 2, 1}, 6));
//        System.out.println(wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});


        System.out.println(rangeFreqQuery.query(0, 11, 33));
    }

    /**
     * <pre>
     * 输入：plants = [1,1,1,4,2,3], capacity = 4
     * 输出：30
     * 解释：从河边开始，此时水罐是装满的：
     * - 走到植物 0，1，2 (3 步) ，浇水。回到河边取水 (3 步)。
     * - 走到植物 3 (4 步) ，浇水。回到河边取水 (4 步)。
     * - 走到植物 4 (5 步) ，浇水。回到河边取水 (5 步)。
     * - 走到植物 5 (6 步) ，浇水。
     * 需要的步数是 = 3 + 3 + 4 + 4 + 5 + 5 + 6 = 30 。
     * </pre>
     *
     * @param plants   植物数组
     * @param capacity 罐子容量
     * @return 步数
     */
    public int wateringPlants(int[] plants, int capacity) {
        int step = 0;
        // 水源位置
        int x = -1;
        int size = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] <= capacity) {
                capacity -= plants[i];
                step++;
            } else {
                step += 2 * i + 1;
                capacity = size - plants[i];
            }
        }
        return step;
    }
}

/**
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * <p>
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * <p>
 * 请你实现 RangeFreqQuery 类：
 * <p>
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 */
class RangeFreqQuery {

    private int[] arr;
    private Set<Integer> set = new HashSet<>();

    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        for (int i : arr) {
            set.add(i);
        }
    }

    public int query(int left, int right, int value) {
        int nums = 0;
        if (!set.contains(value)) {
            return 0;
        }
        int[] dest = new int[right - left + 1];
        System.arraycopy(arr, left, dest, 0, right - left + 1);
        Arrays.sort(dest);

        int i = 0;
        int j = dest.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (dest[mid] == value) {
                nums++;
                i++;
                j--;
            } else if (dest[mid] > value) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return nums;
    }
}
