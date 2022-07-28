package normal.easy.question_1213.IntersectionOfThreeSortedArrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.
 * 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。
 * 返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays">intersection-of-three-sorted-arrays</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [1,2,3,4,5]
 * [1,2,5,7,9]
 * [1,3,4,5,8]
 *
 * @author Jungle
 * @since 2021/7/11 22:04
 */
public class Solution {
    @Test
    public void test() {
        String a = "a,b,c,d,e,f,g,h,i,j,k";
        System.out.println(Collections.singletonList(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8}));
    }

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
//        List<Integer> a = new ArrayList<>();
//        List<Integer> b = new ArrayList<>();
//        List<Integer> c = new ArrayList<>();
//        for (int i : arr1) {
//            a.add(i);
//        }
//        for (int i : arr2) {
//            b.add(i);
//        }
//        for (int i : arr3) {
//            c.add(i);
//        }
//        if (a.retainAll(b)) a.retainAll(c);
//        return a;


        List<Integer> result = new ArrayList<>();
        for (int value : arr1) {
            int left = 0, right = arr2.length - 1;
            while (left <= right) {
                int middle = (left + right) >> 1;
                if (arr2[middle] < value) {
                    left = middle + 1;
                } else if (arr2[middle] > value) {
                    right = middle - 1;
                } else {
                    int low = 0, high = arr3.length - 1;
                    while (low <= high) {
                        int mid = (low + high) >> 1;
                        if (arr3[mid] < value) {
                            low = mid + 1;
                        } else if (arr3[mid] > value) {
                            high = mid - 1;
                        } else {
                            result.add(value);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
}
