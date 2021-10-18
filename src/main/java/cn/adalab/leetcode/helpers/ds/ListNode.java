package cn.adalab.leetcode.helpers.ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * LeetCode #19
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();
        ListNode curr = this;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return "[" + list.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }
}


