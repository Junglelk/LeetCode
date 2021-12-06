package normal.medium.question_0173.BinarySearchTreeIterator;

import other.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 *
 * <pre>
 *  1. BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 *  2. boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 *  3. int next() Moves the pointer to the right, then returns the number at the pointer.
 * </pre>
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 * <p>
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 * <p>
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * <pre>
 *  1. BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 *  2. boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 *  3. int next()将指针向右移动，然后返回指针处的数字。
 * </pre>
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2021/12/6 22:24
 */
public class BSTIterator {

    private List<Integer> arr;
    private int index;

    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        index = 0;
        inorder(root, arr);
    }

    private void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public int next() {
        return arr.get(index++);
    }

    public boolean hasNext() {
        return index > arr.size();
    }
}
