package cn.adalab.leetcode.helpers;

import cn.adalab.leetcode.helpers.ds.ListNode;
import cn.adalab.leetcode.helpers.ds.TreeNode;

import static org.junit.jupiter.api.Assertions.assertTrue;

/** A mixin to enhance the assertion capabilities of {@link SolutionRunner}. */
interface AssertMixin {
  default void assertSameTree(TreeNode root1, TreeNode root2) {
    assertTrue(isSameTree(root1, root2));
  }

  default void assertSameList(ListNode head1, ListNode head2) {
    assertTrue(isSameList(head1, head2));
  }

  /**
   * Check if two leetcode lists are the same.
   *
   * @param head1 head of list 1
   * @param head2 head of list 2
   * @return true if same, false otherwise
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
   * Check if two leetcode trees are the same.
   *
   * @param root1 head of tree 1
   * @param root2 head of tree 2
   * @return true if same, false otherwise
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
