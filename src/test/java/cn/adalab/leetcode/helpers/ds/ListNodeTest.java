package cn.adalab.leetcode.helpers.ds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {
    @Test
    void testToString() {
        var head = new ListNode(1);
        assertEquals("[1]", head.toString());
        head.next = new ListNode(9);
        assertEquals("[1,9]", head.toString());
    }
}