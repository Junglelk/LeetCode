package competition.medium.competition_5201.WateringPlants;

/**
 * You want to water n plants in your garden with a watering can. The plants are arranged in a row and are labeled from 0 to n - 1 from left to right where the ith plant is located at x = i. There is a river at x = -1 that you can refill your watering can at.
 * <p>
 * Each plant needs a specific amount of water. You will water the plants in the following way:
 * <p>
 * Water the plants in order from left to right.
 * After watering the current plant, if you do not have enough water to completely water the next plant, return to the river to fully refill the watering can.
 * You cannot refill the watering can early.
 * You are initially at the river (i.e., x = -1). It takes one step to move one unit on the x-axis.
 * <p>
 * Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the ith plant needs, and an integer capacity representing the watering can capacity, return the number of steps needed to water all the plants.
 * <p>
 * 你打算用一个水罐给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。其中，第 i 株植物的位置是 x = i 。x = -1 处有一条河，你可以在那里重新灌满你的水罐。
 * <p>
 * 每一株植物都需要浇特定量的水。你将会按下面描述的方式完成浇水：
 * <p>
 * 按从左到右的顺序给植物浇水。
 * 在给当前植物浇完水之后，如果你没有足够的水 完全 浇灌下一株植物，那么你就需要返回河边重新装满水罐。
 * 你 不能 提前重新灌满水罐。
 * 最初，你在河边（也就是，x = -1），在 x 轴上每移动 一个单位 都需要 一步 。
 * <p>
 * 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。另有一个整数 capacity 表示水罐的容量，返回浇灌所有植物需要的 步数 。
 * <p>
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/watering-plants
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/11/21 15:02
 */
public class Solution {
    /**
     * 直观地翻译步骤
     *
     * @param plants   植物数组
     * @param capacity 水壶容量
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
