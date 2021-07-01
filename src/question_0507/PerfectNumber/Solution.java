package question_0507.PerfectNumber;

/**
 * @author Jungle
 * @since 2021/6/20 22:12
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }

    public static boolean checkPerfectNumber(int num) {
        int half = num / 2;
        int sum = 0;
        for (int i = 1; i <= half; i++) {
            if ((num % i) == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum == num;
    }
}