package cn.adalab.leetcode.helpers.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeNodeTest {
    @Test
    void toStringTest() {
        var root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        assertEquals("[5,4,6,2,null,null,7]", root.toString());
    }
}