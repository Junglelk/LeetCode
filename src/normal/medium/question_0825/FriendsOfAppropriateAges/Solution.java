package normal.medium.question_0825.FriendsOfAppropriateAges;

import java.util.Arrays;

/**
 * There are n persons on a social media website. You are given an integer array ages where ages[i] is the age of the ith person.
 * <p>
 * A Person x will not send a friend request to a person y (x != y) if any of the following conditions is true:
 * <pre>
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 *  </pre>
 * Otherwise, x will send a friend request to y.
 * <p>
 * Note that if x sends a request to y, y will not necessarily send a request to x. Also, a person will not send a friend request to themself.
 * <p>
 * Return the total number of friend requests made.
 * <p>
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 * <p>
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 * <pre>
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * </pre>
 * 否则，x 将会向 y 发送一条好友请求。
 * <p>
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 * <p>
 * 返回在该社交媒体网站上产生的好友请求总数。
 * <pre>
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/27 21:32
 */
public class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);

        int left = 0;
        int right = 0;
        int ans = 0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * ages[i] + 7) {
                ++left;
            }
            while (right + 1 < ages.length && ages[right + 1] <= ages[i]) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }
}