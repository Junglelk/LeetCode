package normal.medium.question_0735.AsteroidCollision;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/asteroid-collision">asteroid-collision</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    @Test
    public void test() {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, -5, 10})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 1, -5, 2, -9, 2, -6, 8, -9, -8, -1, 2, 2, 5, 6, 9, -7, -8, 5, 12, -9, 2, -5})));
    }


    public int[] asteroidCollision(int[] asteroids) {
        while (true) {
            if (!explode(asteroids)) {
                break;
            }
        }
        int nums = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                nums++;
            }
        }
        int[] ret = new int[nums];
        nums = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                ret[nums++] = asteroid;
            }
        }
        return ret;
    }

    public boolean explode(int[] asteroids) {
        boolean flag = false;

        for (int i = 0; i < asteroids.length - 1; i++) {
            if (asteroids[i] <= 0) {
                continue;
            }
            for (int j = i + 1; j < asteroids.length; j++) {
                if (asteroids[j] == 0) {
                    continue;
                }
                if (asteroids[j] > 0) {
                    break;
                }
                if (asteroids[i] > -asteroids[j]) {
                    asteroids[j] = 0;
                } else if (asteroids[i] < -asteroids[j]) {
                    asteroids[i] = 0;
                } else {
                    asteroids[i] = 0;
                    asteroids[j] = 0;
                }
                flag = true;
                break;
            }
            if (flag) {
                break;
            }
        }

        return flag;
    }
}
