package cn.adalab.leetcode.helpers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputMixinTest {

  InputMixin inputMixin = new InputMixin() {};

  /** #19 sample 1 */
  @Test
  void linkedListHead1() {
    var head = inputMixin.toListNode("[1,2,3,4,5]");
    assertNotNull(head);
    assertEquals(1, head.val);
    assertEquals(2, head.next.val);
    assertEquals(3, head.next.next.val);
    assertEquals(4, head.next.next.next.val);
    assertEquals(5, head.next.next.next.next.val);
    assertNull(head.next.next.next.next.next);
  }

  @Test
  void linkedListHead2() {
    var head = inputMixin.toListNode("[]");
    assertNull(head);
  }

  /** #94 sample 1 */
  @Test
  void binaryTreeRoot1() {
    var root = inputMixin.toTreeNode("[1,null,2,3]");
    assertEquals(1, root.val);
    assertNull(root.left);
    assertEquals(2, root.right.val);
    assertEquals(3, root.right.left.val);
    assertNull(root.right.right);
  }

  /** #94 sample 2 */
  @Test
  void binaryTreeRoot2() {
    var root = inputMixin.toTreeNode("[]");
    assertNull(root);
  }

  /** #94 sample 3 */
  @Test
  void binaryTreeRoot3() {
    var root = inputMixin.toTreeNode("[1]");
    assertEquals(1, root.val);
    assertNull(root.left);
    assertNull(root.right);
  }

  /** #94 sample 4 */
  @Test
  void binaryTreeRoot4() {
    var root = inputMixin.toTreeNode("[1,2]");
    assertEquals(1, root.val);
    assertEquals(2, root.left.val);
    assertNull(root.left.left);
    assertNull(root.left.right);
    assertNull(root.right);
  }

  /** #94 sample 5 */
  @Test
  void binaryTreeRoot5() {
    var root = inputMixin.toTreeNode("[1,null,2]");
    assertEquals(1, root.val);
    assertNull(root.left);
    assertEquals(2, root.right.val);
    assertNull(root.right.left);
    assertNull(root.right.right);
  }

  @Test
  void intArray2D() {
    var array2D = inputMixin.toIntArray2D("[[1,2],[3,4]]");
    assertEquals(1, array2D[0][0]);
  }

  /** #118 sample 1 output */
  @Test
  void nestedIntegerList() {
    var result = inputMixin.toListListInteger("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]");
    assertEquals(5, result.size());
    assertEquals(List.of(1), result.get(0));
    assertEquals(List.of(1, 1), result.get(1));
    assertEquals(List.of(1, 2, 1), result.get(2));
    assertEquals(List.of(1, 3, 3, 1), result.get(3));
    assertEquals(List.of(1, 4, 6, 4, 1), result.get(4));
  }

  /** #524 */
  @Test
  void stringList() {
    var result = inputMixin.toListString("[\"ale\",\"apple\",\"monkey\",\"plea\"]");
    assertEquals(4, result.size());
    assertEquals("ale", result.get(0));
    assertEquals("monkey", result.get(2));
  }

  /** #130 */
  @Test
  void charArray2D() {
    var result = inputMixin.toCharArray2D("[[\"X\"]]");
    assertEquals(1, result.length);
    assertEquals(1, result[0].length);
    assertEquals('X', result[0][0]);
  }

  /** #133 */
  @Test
  void graphNode() {
    var node1 = inputMixin.toNode("[[2,4],[1,3],[2,4],[1,3]]");
    assertEquals(1, node1.val);
    assertEquals(2, node1.neighbors.size());
    var node2 = node1.neighbors.get(0);
    assertEquals(2, node2.val);
    assertEquals(2, node2.neighbors.size());
    assertSame(node1, node2.neighbors.get(0));
    var node3 = node2.neighbors.get(1);
    assertEquals(3, node3.val);
    assertEquals(2, node3.neighbors.size());
    assertSame(node2, node3.neighbors.get(0));
    var node4 = node1.neighbors.get(1);
    assertEquals(4, node4.val);
    assertEquals(2, node4.neighbors.size());
    assertSame(node4, node3.neighbors.get(1));
    assertSame(node1, node4.neighbors.get(0));
    assertSame(node3, node4.neighbors.get(1));
  }
}
