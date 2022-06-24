package cn.adalab.leetcode.helpers.ds;

import java.util.List;

/**
 * #341
 */
public interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}