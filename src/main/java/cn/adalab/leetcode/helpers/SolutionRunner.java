package cn.adalab.leetcode.helpers;

import org.junit.jupiter.api.Assertions;

/**
 * This abstract runner class should be inherited with {@link #run()} overridden to test and debug
 * your code.
 */
public abstract class SolutionRunner extends Assertions implements AssertMixin, InputMixin {
  public abstract void run();

  /**
   * Program entrance. Reflectively found the real subclass and invoke its {@code run} method.
   *
   * @param args arguments, mostly nothing at all
   */
  public static void main(String[] args) throws ReflectiveOperationException {
    var command = System.getProperty("sun.java.command");

    // strip the module part if any
    var clazzName = command.substring(command.lastIndexOf('/') + 1);
    var clazz = Class.forName(clazzName);
    SolutionRunner solutionRunner = (SolutionRunner) clazz.getDeclaredConstructor().newInstance();
    solutionRunner.run();
  }
}
