import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }


    public boolean areNumbersAscending(String s) {
        List<Integer> list = new ArrayList<>();
        String[] ret = s.split(" ");
        for (String s1 : ret) {
            if (Character.isDigit(s1.charAt(0))) {
                list.add(Integer.parseInt(s1));
            }
        }

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public int countMaxOrSubsets(int[] nums) {

        int maxNum = 0;
        for (int num : nums) {
            maxNum |= num;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < nums.length - 1; j++) {
                temp = nums[i] | nums[j];
                if (temp == maxNum) {
                    break;
                }
            }
            result += (int) Math.pow(2, nums.length - i) - 1;
        }

        return result;
    }
}

/**
 * 实现 Bank 类：
 * <p>
 * Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
 * <p>
 * boolean transfer(int account1, int account2, long money) 从编号为 account1 的账户向编号为 account2 的账户转帐 money 美元。
 * <p>
 * 如果交易成功，返回 true ，否则，返回 false 。
 * <p>
 * boolean deposit(int account, long money) 向编号为 account 的账户存款 money 美元。
 * <p>
 * 如果交易成功，返回 true ；否则，返回 false 。
 * <p>
 * boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。
 * <p>
 * 如果交易成功，返回 true ；否则，返回 false 。
 *
 * <pre>
 * 输入：
 * ["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
 * [[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]
 * 输出：
 * [null, true, true, true, false, false]
 *
 * 解释：
 * Bank bank = new Bank([10, 100, 20, 50, 30]);
 * bank.withdraw(3, 10);    // 返回 true ，账户 3 的余额是 $20 ，所以可以取款 $10 。
 *                          // 账户 3 余额为 $20 - $10 = $10 。
 * bank.transfer(5, 1, 20); // 返回 true ，账户 5 的余额是 $30 ，所以可以转账 $20 。
 *                          // 账户 5 的余额为 $30 - $20 = $10 ，账户 1 的余额为 $10 + $20 = $30 。
 * bank.deposit(5, 20);     // 返回 true ，可以向账户 5 存款 $20 。
 *                          // 账户 5 的余额为 $10 + $20 = $30 。
 * bank.transfer(3, 4, 15); // 返回 false ，账户 3 的当前余额是 $10 。
 *                          // 所以无法转账 $15 。
 * bank.withdraw(10, 50);   // 返回 false ，交易无效，因为账户 10 并不存在。
 * </pre>
 */
class Bank {

    long[] balance;
    int accountNum;

    public Bank(long[] balance) {
        this.balance = balance;
        accountNum = balance.length + 1;
    }

    /**
     * 转账
     *
     * @param account1 源账户
     * @param account2 目标账户
     * @param money    钱数
     * @return 是否成功
     */
    public boolean transfer(int account1, int account2, long money) {
        if (account1 > accountNum || account2 > accountNum) {
            return false;
        }
        if (balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    /**
     * 存入
     *
     * @param account 账号
     * @param money   钱数
     * @return 是否成功
     */
    public boolean deposit(int account, long money) {
        if (account > accountNum) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    /**
     * 取出
     *
     * @param account 账号
     * @param money   钱数
     * @return 是否成功
     */
    public boolean withdraw(int account, long money) {
        if (account > accountNum) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
