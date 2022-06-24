package cn.adalab.leetcode.helpers.ds;

import java.util.*;
import java.util.stream.Collectors;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  /**
   * #94
   */
  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  /**
   * Convert to level-order traversal string.
   * <p>
   * Example:
   * <pre>
   *      1────────┐
   *            ┌──2
   *         ┌──3
   *         4
   * </pre>
   * is converted to {@code [1,null,2,3,null,4]}
   *
   * Algorithm:
   * 1.
   * @return converted string
   */
  @Override
  public String toString() {
    var queue = new ArrayDeque<Optional<TreeNode>>();
    var list = new ArrayList<Integer>();
    queue.add(Optional.of(this));
    while (!queue.isEmpty()) {
      var node = queue.poll().orElse(null);
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