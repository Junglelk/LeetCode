import org.junit.Test;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
        System.out.println(minimumRefill(new int[]{2,1,1}, 2, 2));
    }

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
        int n = plants.length;
        int count = 0;
        int a = 0;
        int b = n - 1;
        int ca = capacityA;
        int cb = capacityB;
        while (a <= b) {
            if (a == b) {
                if (cb > ca && cb > plants[a]) {
                    break;
                } else {
                    if (ca < plants[a]) {
                        count++;
                        break;
                    }
                }
            }
            if (ca >= plants[a]) {
                ca -= plants[a];
                a++;
            } else {
                a++;
                count++;
            }

            if (cb >= plants[b]) {
                cb -= plants[b];
                b--;
            } else {
                b--;
                count++;
            }
        }


        return count;
    }
}

