package cn.adalab.leetcode.helpers.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类是LeetCode上#138、#116题目中的Node类进行合并得到的类
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public List<Node> neighbors;    // #133

    public Node() {
    }

    /**
     * 用于#138、#116、#133的构造函数
     */
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        neighbors = new ArrayList<>();
    }

    /**
     * 用于#138的构造函数
     */
    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    /**
     * LeetCode上剑指Offer 36的构造函数
     */
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 用于#133的构造函数
     */
    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}