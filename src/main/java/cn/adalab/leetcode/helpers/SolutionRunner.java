package cn.adalab.leetcode.helpers;

import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;

public class SolutionRunner extends Assertions implements Asserts, InputHelper {
    public void run() {
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String command = System.getProperty("sun.java.command");
        Class<?> clazz = Class.forName(command.split(" ")[0]);
        SolutionRunner solutionRunner = (SolutionRunner) clazz.getDeclaredConstructor().newInstance();
        solutionRunner.run();
    }
}
