package competition.medium.competition_5954.WateringPlantsII;

/**
 * Alice and Bob want to water n plants in their garden. The plants are arranged in a row and are labeled from 0 to n - 1 from left to right where the ith plant is located at x = i.
 * <p>
 * Each plant needs a specific amount of water. Alice and Bob have a watering can each, initially full. They water the plants in the following way:
 * <pre>
 * Alice waters the plants in order from left to right, starting from the 0th plant. Bob waters the plants in order from right to left, starting from the (n - 1)th plant. They begin watering the plants simultaneously.
 * If one does not have enough water to completely water the current plant, he/she refills the watering can instantaneously.
 * It takes the same amount of time to water each plant regardless of how much water it needs.
 * One cannot refill the watering can early.
 * Each plant can be watered either by Alice or by Bob.
 * In case both Alice and Bob reach the same plant, the one with more water currently in his/her watering can should water this plant. If they have the same amount of water, then Alice should water this plant.
 * </pre>
 * Given a 0-indexed integer array plants of n integers, where plants[i] is the amount of water the ith plant needs, and two integers capacityA and capacityB representing the capacities of Alice's and Bob's watering cans respectively, return the number of times they have to refill to water all the plants.
 * Alice 和 Bob 打算给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。其中，第 i 株植物的位置是 x = i 。
 * <p>
 * 每一株植物都需要浇特定量的水。Alice 和 Bob 每人有一个水罐，最初是满的 。他们按下面描述的方式完成浇水：
 * <pre>
 *  Alice 按 从左到右 的顺序给植物浇水，从植物 0 开始。Bob 按 从右到左 的顺序给植物浇水，从植物 n - 1 开始。他们 同时 给植物浇水。
 * 如果没有足够的水 完全 浇灌下一株植物，他 / 她会立即重新灌满浇水罐。
 * 不管植物需要多少水，浇水所耗费的时间都是一样的。
 * 不能 提前重新灌满水罐。
 * 每株植物都可以由 Alice 或者 Bob 来浇水。
 * 如果 Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水。如果他俩水量相同，那么 Alice 会给这株植物浇水。
 * </pre>
 * 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。另有两个整数 capacityA 和 capacityB 分别表示 Alice 和 Bob 水罐的容量。返回两人浇灌所有植物过程中重新灌满水罐的 次数 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/watering-plants-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/12 22:19
 */
public class Solution {
    /**
     * 输入：plants = [2,2,3,3], capacityA = 3, capacityB = 4
     * 输出：2
     * 解释：
     * - 最初，Alice 的水罐中有 3 单元水，Bob 的水罐中有 4 单元水。
     * - Alice 给植物 0 浇水，Bob 给植物 3 浇水。
     * - Alice 和 Bob 现在都只有 1 单元水，并分别需要给植物 1 和植物 2 浇水。
     * - 由于他们的水量均不足以浇水，所以他们重新灌满水罐再进行浇水。
     * 所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 + 1 + 1 + 0 = 2 。
     *
     * @param plants    植物数组
     * @param capacityA a
     * @param capacityB b
     * @return 灌水次数
     */
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        // 灌满水罐次数
        int res = 0;
        // 两人位置
        int n = plants.length;
        // 两人剩余水量
        int ca = 0;
        int cb = n - 1;
        int A = capacityA;
        int B = capacityB;
        // 模拟相遇前的浇水过程
        while (ca < cb) {
            if (A < plants[ca]) {
                ++res;
                A = capacityA - plants[ca];
            } else {
                A -= plants[ca];
            }
            ++ca;
            if (B < plants[cb]) {
                ++res;
                B = capacityB - plants[cb];
            } else {
                B -= plants[cb];
            }
            --cb;
        }
        // 模拟相遇后可能的浇水过程
        if (ca == cb) {
            if (A >= B && A < plants[ca]) {
                ++res;
            }
            if (A < B && B < plants[cb]) {
                ++res;
            }
        }
        return res;
    }
}
