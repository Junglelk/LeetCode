package competition.easy.competition_6031.FindAllK_DistantIndicesInAnArray;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a 0-indexed integer array nums and two integers key and k. A k-distant index is an index i of nums for which there exists at least one index j such that |i - j| <= k and nums[j] == key.
 * <p>
 * Return a list of all k-distant indices sorted in increasing order.
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
 * <p>
 * 以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
 * <pre>
 * 输入：nums = [3,4,9,1,3,9,5], key = 9, k = 1
 * 输出：[1,2,3,4,5,6]
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-k-distant-indices-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/13 21:18
 */
public class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int l = i - k;
                int r = i + k;
                for (int j = l; j <= r; j++) {
                    if (j >= 0 && j < nums.length && !visited[j]) {
                        visited[j] = true;
                        list.add(j);
                    }
                }
            }
        }
        return list;
    }
}