package normal.easy.question_0406.QueueReconstructionByHeight;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
 * <p>
 * Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 * <p>
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/queue-reconstruction-by-height">queue-reconstruction-by-height</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    @Test
    public void test() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        //4,4 5,0 5,2 6,1 7,0 7,1
        //2,0 5,0 7,0 8,0 9,0 5,4 2,7 1,8, 4,5
        people = reconstructQueue(people);

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] p : people) {
            int num = p[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (ans[i] == null) {
                    if ((--num) == 0) {
                        ans[i] = p;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
