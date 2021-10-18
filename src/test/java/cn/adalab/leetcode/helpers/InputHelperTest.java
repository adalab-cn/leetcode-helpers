package cn.adalab.leetcode.helpers;

import cn.adalab.leetcode.helpers.ds.ListNode;
import cn.adalab.leetcode.helpers.ds.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputHelperTest {

    InputHelper inputHelper = new InputHelper() {
    };

    /**
     * #19 sample 1
     */
    @Test
    public void linkedListHead1() {
        ListNode head = inputHelper.toLinkedList("[1,2,3,4,5]");
        assertNotNull(head);
        assertEquals(1, head.val);
        assertEquals(2, head.next.val);
        assertEquals(3, head.next.next.val);
        assertEquals(4, head.next.next.next.val);
        assertEquals(5, head.next.next.next.next.val);
        assertNull(head.next.next.next.next.next);
    }

    @Test
    public void linkedListHead2() {
        ListNode head = inputHelper.toLinkedList("[]");
        assertNull(head);
    }

    /**
     * #94 sample 1
     */
    @Test
    public void binaryTreeRoot1() {
        TreeNode root = inputHelper.toBinaryTree("[1,null,2,3]");
        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.left.val);
        assertNull(root.right.right);
    }

    /**
     * #94 sample 2
     */
    @Test
    public void binaryTreeRoot2() {
        TreeNode root = inputHelper.toBinaryTree("[]");
        assertNull(root);
    }

    /**
     * #94 sample 3
     */
    @Test
    public void binaryTreeRoot3() {
        TreeNode root = inputHelper.toBinaryTree("[1]");
        assertEquals(1, root.val);
        assertNull(root.left);
        assertNull(root.right);
    }

    /**
     * #94 sample 4
     */
    @Test
    public void binaryTreeRoot4() {
        TreeNode root = inputHelper.toBinaryTree("[1,2]");
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertNull(root.right);
    }

    /**
     * #94 sample 5
     */
    @Test
    public void binaryTreeRoot5() {
        TreeNode root = inputHelper.toBinaryTree("[1,null,2]");
        assertEquals(1, root.val);
        assertNull(root.left);
        assertEquals(2, root.right.val);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    public void intArray2D() {
        int[][] array2D = inputHelper.toIntArray2D("[[1,2],[3,4]]");
        assertEquals(1, array2D[0][0]);
    }
}