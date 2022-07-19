# LeetCode Helpers ![unit test](https://github.com/adalab-cn/leetcode-helpers/actions/workflows/unit-test.yml/badge.svg)

A library to help one crack leetcode problems in Java.

## Usage

Extend `SolutionRunner`, write your solution, and test your code.

```java
import cn.adalab.leetcode.helpers.ds.ListNode;

public class P21 extends SolutionRunner {

   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      // your solution code
   }

   /**
    * If needed, test your code with inherited methods like {@code assertSameList} and {@code toListNode}.
    */
   @Override
   public void run() {
      ListNode head1 = toListNode("[1,2,4]");
      ListNode head2 = toListNode("[1,3,4]");
      ListNode merged = mergeTwoLists(head1, head2);
      System.out.println(merged);
      assertSameList(toListNode("[1,1,2,3,4,4]"), merged);
   }

}
```

## Credits

This project is inspired by:

1. [leetcode-helper](https://github.com/helloShen/leetcode-helper)
2. [leetcode](https://github.com/starforever/leetcode)

# TODO

1. Should `SolutionRunner` expose assertion APIs? Problems like 450 may have more than one correct outputs, so assertion
   failures does not necessarily mean wrong solution. Assertion APIs could be misused here. 