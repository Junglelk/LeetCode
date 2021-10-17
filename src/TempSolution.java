import org.junit.Test;

import java.util.Arrays;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
        System.out.println();
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
