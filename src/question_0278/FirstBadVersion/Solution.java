package question_0278.FirstBadVersion;

/**
 * 这题没啥意思，带情景的题目
 * @author Jungle
 * @since 2021/10/1 10:13
 */
public class Solution {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    boolean isBadVersion(int version){
        return false;
    }
}
