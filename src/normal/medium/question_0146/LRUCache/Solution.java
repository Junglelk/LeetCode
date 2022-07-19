package normal.medium.question_0146.LRUCache;


import java.util.*;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * <li/>LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * <li/>int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * <li/>void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/lru-cache">lru-cache</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public static void main(String[] args) {
        // ["LRUCache","get","put","get","put","put","get","get"]
        // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

class LRUCache {
    private final int capacity;
    private final Deque<Integer> stack;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.stack = new ArrayDeque<>(capacity);
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        stack.remove(key);
        stack.push(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            stack.remove(key);
            stack.push(key);
            return;
        }
        if (stack.size() == capacity) {
            Integer integer = stack.pollLast();
            map.remove(integer);
        }
        map.put(key, value);
        stack.remove(key);
        stack.push(key);
    }
}