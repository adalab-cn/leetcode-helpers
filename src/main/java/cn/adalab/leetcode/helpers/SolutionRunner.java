package cn.adalab.leetcode.helpers;

import org.junit.jupiter.api.Assertions;

/**
 * This abstract runner class should be inherited with {@link #run()} overridden to test and debug
 * your code.
 */
public abstract class SolutionRunner extends Assertions implements AssertMixin, InputMixin {
  public void run() {}

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

    // in case the child class is not public
    var ctor = clazz.getDeclaredConstructor();
    ctor.setAccessible(true);
    SolutionRunner solutionRunner = (SolutionRunner) ctor.newInstance();
    solutionRunner.run();
  }
}
