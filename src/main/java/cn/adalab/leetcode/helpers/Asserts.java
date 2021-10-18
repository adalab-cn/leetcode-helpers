package cn.adalab.leetcode.helpers;

import cn.adalab.leetcode.helpers.ds.ListNode;
import cn.adalab.leetcode.helpers.ds.TreeNode;

import static org.junit.jupiter.api.Assertions.assertTrue;

interface Asserts {
    default void assertSameTree(TreeNode root1, TreeNode root2) {
        assertTrue(isSameTree(root1, root2));
    }

    default void assertSameList(ListNode head1, ListNode head2) {
        assertTrue(isSameList(head1, head2));
    }

    /**
     * 检查两个链表是否一样
     *
     * @param head1 链表1的头
     * @param head2 链表2的头
     * @return 一样返回true，不一样返回false
     */
    private static boolean isSameList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == head2;
        } else if (head1.val != head2.val) {
            return false;
        } else {
            return isSameList(head1.next, head2.next);
        }
    }

    /**
     * 检查两棵树是否一样
     *
     * @param root1 第一棵树的根节点
     * @param root2 第二棵树的根节点
     * @return 一样返回true，不一样返回false
     */
    private static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        } else if (root1.val != root2.val) {
            return false;
        } else {
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
    }
}
