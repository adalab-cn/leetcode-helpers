package cn.adalab.leetcode.helpers.ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode #94
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        Queue<Optional<TreeNode>> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(Optional.of(this));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll().orElse(null);
            if (node != null) {
                list.add(node.val);
                queue.add(Optional.ofNullable(node.left));
                queue.add(Optional.ofNullable(node.right));
            } else {
                list.add(null);
            }
        }

        int rightIndex = list.size();
        while (list.get(rightIndex - 1) == null) {
            rightIndex--;
        }
        return "[" + list.subList(0, rightIndex).stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }
}