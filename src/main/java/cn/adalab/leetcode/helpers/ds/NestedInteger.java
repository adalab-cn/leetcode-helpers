package cn.adalab.leetcode.helpers.ds;

import java.util.List;

/**
 * Provided in #341.
 */
public interface NestedInteger {
  boolean isInteger();

  Integer getInteger();

  List<NestedInteger> getList();
}