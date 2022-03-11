package normal.medium.question_0841.KeysAndRooms;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 * <p>
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * <p>
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
 * <p>
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * <p>
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * <p>
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 * <pre>
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * </pre>
 * <pre>
 *  输入：rooms = [[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 *  </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/3/11 10:42
 */
public class Solution {

    @Test
    public void test() {
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(new LinkedList<>() {{
            add(1);
            add(3);
        }});
        rooms.add(new LinkedList<>() {{
            add(1);
            add(0);
            add(3);
        }});
        rooms.add(new LinkedList<>() {{
            add(2);
        }});
        rooms.add(new LinkedList<>() {{
            add(0);
        }});
        System.out.println(canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(rooms.get(0));
        boolean[] visited = new boolean[rooms.size()];
        int count = 1;
        visited[0] = true;
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            for (Integer i : poll) {
                if (visited[i]) {
                    continue;
                }
                queue.add(rooms.get(i));
                visited[i] = true;
                count++;
            }
        }
        return count == rooms.size();
    }
}
