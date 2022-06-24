package cn.adalab.leetcode.helpers;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;

public abstract class SolutionRunner extends Assertions implements AssertMixin, InputMixin {
    public abstract void run();

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var command = System.getProperty("sun.java.command");

        // strip the module part if any
        var clazzName = command.substring(command.lastIndexOf('/') + 1);
        var clazz = Class.forName(clazzName);
        SolutionRunner solutionRunner = (SolutionRunner) clazz.getDeclaredConstructor().newInstance();
        solutionRunner.run();
    }
}
