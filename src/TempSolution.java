import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Jungle
 * @since 2021/10/17 10:29
 */
public class TempSolution {

    @Test
    public void test() {
//        System.out.println(findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2));
        System.out.println(digArtifacts(6,
                new int[][]
                        {
                                {0, 2, 0, 5},
                                {0, 1, 1, 1},
                                {3, 0, 3, 3},
                                {4, 4, 4, 4},
                                {2, 1, 2, 4}
                        },
                new int[][]{
                        {0, 2},
                        {0, 3},
                        {0, 4},
                        {2, 0},
                        {2, 1},
                        {2, 2},
                        {2, 5},
                        {3, 0},
                        {3, 1},
                        {3, 3},
                        {3, 4},
                        {4, 0},
                        {4, 3},
                        {4, 5},
                        {5, 0},
                        {5, 1},
                        {5, 2},
                        {5, 4},
                        {5, 5}
                }));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int l = i - k;
                int r = i + k;
                for (int j = l; j <= r; j++) {
                    if (j >= 0 && j < nums.length && !visited[j]) {
                        visited[j] = true;
                        list.add(j);
                    }
                }
            }
        }
        return list;
    }

    /**
     * @param n         工件个数
     * @param artifacts 工件埋藏
     * @param dig       挖掘列表
     * @return 能挖的工件个数
     */
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] visited = new boolean[n][n];
        for (int[] site : dig) {
            visited[site[0]][site[1]] = true;
        }
        int count = 0;
        for (int[] artifact : artifacts) {
            boolean temp = true;
            int xr = artifact[0];
            int yr = artifact[1];
            int xl = artifact[2];
            int yl = artifact[3];
            for (int i = xr; i <= xl; i++) {
                for (int j = yr; j <= yl; j++) {
                    temp = (temp && visited[i][j]);
                }
            }
            if (temp) {
                count++;
            }
        }
        return count;
    }
// [99,95,68,24,18]
//69
    @Test
    public void test2() {
        System.out.println(maximumTop(new int[]{99,95,68,24,18}, 69));
    }

//[35,43,23,86,23,45,84,2,18,83,79,28,54,81,12,94,14,0,0,29,94,12,13,1,48,85,22,95,24,5,73,10,96,97,72,41,52,1,91,3,20,22,41,98,70,20,52,48,91,84,16,30,27,35,69,33,67,18,4,53,86,78,26,83,13,96,29,15,34,80,16,49]
//15
    public int maximumTop(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }

        for (int i = 0; i < k; i++) {
            if (!stack.isEmpty())
            stack.pop();
        }
        int max;
        if (stack.isEmpty()) {
            max = Integer.MIN_VALUE;
        } else {
            max = stack.peek();
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        while (k > 0) {
            if (k == 1 && !priorityQueue.isEmpty()) {
                if (priorityQueue.peek() < stack.peek()) {
                    priorityQueue.add(stack.pop());
                } else {
                    stack.push(priorityQueue.poll());
                }
                k--;
            } else {
                if (!stack.isEmpty()) {
                    priorityQueue.add(stack.pop());
                }
            }
            k--;
        }
        if (!stack.isEmpty()) {
            return Math.max(stack.peek(), max);
        }
        return -1;
    }
}

