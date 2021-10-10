package competition_5894.TwoOutOfThree;

import java.util.*;
import java.util.Map.Entry;

/**
 * Given three integer arrays nums1, nums2, and nums3,
 * <p>
 * return a distinct array containing all the values that are present in at least two out of the three arrays.
 * <p>
 * You may return the values in any order.
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 不同 数组，且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
 *
 * @author Jungle
 * @since 2021/10/10 10:31
 */
public class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : set) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        set.clear();
        for (int i : nums2) {
            set.add(i);
        }
        for (int i : set) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        set.clear();
        for (int i : nums3) {
            set.add(i);
        }
        for (int i : set) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> a = new ArrayList<>();

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                a.add(entry.getKey());
            }
        }

        return a;
    }
}
