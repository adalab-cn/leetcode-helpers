/*
 * copied from https://github.com/openjdk/jfx/blob/8.0-b132/modules/base/src/main/java/javafx/util/Pair.java
 *
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package cn.adalab.leetcode.helpers.ds;

import java.io.Serializable;
import java.util.Objects;

/**
 * A convenience class to represent name-value pairs.
 *
 * @since JavaFX 2.0
 */
public class Pair<K, V> implements Serializable {

  /** Key of this <code>Pair</code>. */
  private final K key;

  /**
   * Gets the key for this pair.
   *
   * @return key for this pair
   */
  @SuppressWarnings("unused")
  public K getKey() {
    return key;
  }

  /** Value of this <code>Pair</code>. */
  private final V value;

  /**
   * Gets the value for this pair.
   *
   * @return value for this pair
   */
  @SuppressWarnings("unused")
  public V getValue() {
    return value;
  }

  /**
   * Creates a new pair
   *
   * @param key The key for this pair
   * @param value The value to use for this pair
   */
  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * <code>String</code> representation of this <code>Pair</code>.
   *
   * <p>The default name/value delimiter '=' is always used.
   *
   * @return <code>String</code> representation of this <code>Pair</code>
   */
  @Override
  public String toString() {
    return key + "=" + value;
  }

  /**
   * Generate a hash code for this <code>Pair</code>.
   *
   * <p>The hash code is calculated using both the name and the value of the <code>Pair</code>.
   *
   * @return hash code for this <code>Pair</code>
   */
  @Override
  public int hashCode() {
    // name's hashCode is multiplied by an arbitrary prime number (13)
    // in order to make sure there is a difference in the hashCode between
    // these two parameters:
    //  name: a  value: aa
    //  name: aa value: a
    return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
  }

  /**
   * Test this <code>Pair</code> for equality with another <code>Object</code>.
   *
   * <p>If the <code>Object</code> to be tested is not a <code>Pair</code> or is <code>null</code>,
   * then this method returns <code>false</code>.
   *
   * <p>Two <code>Pair</code>s are considered equal if and only if both the names and values are
   * equal.
   *
   * @param o the <code>Object</code> to test for equality with this <code>Pair</code>
   * @return <code>true</code> if the given <code>Object</code> is equal to this <code>Pair</code>
   *     else <code>false</code>
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof Pair) {
      @SuppressWarnings("rawtypes") Pair pair = (Pair) o;
      if (!Objects.equals(key, pair.key)) return false;
      return Objects.equals(value, pair.value);
    }
    return false;
  }
}
