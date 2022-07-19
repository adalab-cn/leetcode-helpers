package cn.adalab.leetcode.helpers;

import cn.adalab.leetcode.helpers.ds.ListNode;
import cn.adalab.leetcode.helpers.ds.TreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** A mixin to enhance the input parsing capabilities of {@link SolutionRunner}. */
interface InputMixin {
  /** #57. */
  default int[] toIntArray(String input) {
    String[] strNodes = input.trim().replaceAll("[\\[\\]]", "").split("\\s*,\\s*");
    if (strNodes[0].isEmpty()) {
      return null;
    } else {
      return Stream.of(strNodes).map(Integer::parseInt).mapToInt(x -> x).toArray();
    }
  }

  /** #57, #435. Eg. [[1,2],[2,3],[3,4],[1,3]] */
  default int[][] toIntArray2D(String input) {
    String[] strings = input.trim().replaceAll("(^\\[)|(]$)", "").split("\\s*,\\s*(?=\\[)");
    return Stream.of(strings).map(this::toIntArray).toArray(int[][]::new);
  }

  /** #19. */
  default ListNode toListNode(String input) {
    String[] strNodes = input.trim().replaceAll("[\\[\\]]", "").split("\\s*,\\s*");
    if (strNodes[0].isEmpty()) {
      return null;
    } else {
      List<ListNode> list =
          Stream.of(strNodes)
              .map(Integer::parseInt)
              .map(ListNode::new)
              .collect(Collectors.toList());
      for (int i = 0; i < list.size() - 1; i++) {
        list.get(i).next = list.get(i + 1);
      }
      return list.get(0);
    }
  }

  /** #94. Eg. [1,null,2,3] */
  default TreeNode toTreeNode(String input) {
    String[] strNodes = input.trim().replaceAll("[\\[\\]]", "").split("\\s*,\\s*");
    if (strNodes[0].isEmpty()) {
      return null;
    } else {
      List<TreeNode> nodes =
          Stream.of(strNodes)
              .map(
                  str -> {
                    if (str.equals("null")) {
                      return null;
                    } else {
                      return new TreeNode(Integer.parseInt(str));
                    }
                  })
              .collect(Collectors.toList());

      return levelOrderToBinaryTree(nodes);
    }
  }

  default char[][] toCharArray2D(String input) {
    String[] strings = input.trim().replaceAll("(^\\[)|(]$)", "").split("\\s*,\\s*(?=\\[)");
    return Stream.of(strings).map(InputMixin::toCharArray).toArray(char[][]::new);
  }

  private static char[] toCharArray(String input) {
    return input.trim().replaceAll("[\\[\\]\"]", "").toCharArray();
  }

  /**
   * Construct a binary tree based on the level order traversal output.
   *
   * @param nodes level order traversal
   * @return the constructed tree
   */
  private static TreeNode levelOrderToBinaryTree(List<TreeNode> nodes) {
    if (nodes.isEmpty()) {
      return null;
    } else {
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(nodes.get(0));

      boolean isNextNodeLeft = true;
      TreeNode curr = null;
      for (int i = 1; i < nodes.size(); i++) {
        TreeNode child = nodes.get(i);
        if (isNextNodeLeft) {
          curr = queue.poll();
          //noinspection ConstantConditions
          curr.left = child;
        } else {
          curr.right = child;
        }
        isNextNodeLeft = !isNextNodeLeft;
        if (child != null) {
          queue.add(child);
        }
      }
      return nodes.get(0);
    }
  }

  /** #118. */
  default List<List<Integer>> toListListInteger(String input) {
    String[] strings = input.trim().replaceAll("(^\\[)|(]$)", "").split("\\s*,\\s*(?=\\[)");
    return Stream.of(strings)
        .map(this::toIntArray)
        .map(IntStream::of)
        .map(stream -> stream.boxed().collect(Collectors.toList()))
        .collect(Collectors.toList());
  }

  /** #524. */
  default List<String> toListString(String input) {
    String[] strings = input.trim().replaceAll("(^\\[)|(]$)", "").split("\\s*,\\s*");
    return Stream.of(strings).map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
  }
}
