# Intro

Inspired by https://github.com/helloShen/leetcode-helper and https://github.com/starforever/leetcode/tree/master/util

# Notes

1. 也许不应该直接将`assertEquals`在`SolutionRunner`中暴露给用户，因为有些LeetCode题目可能存在多个返回值不同的正确答案，例如#450，只要删除后仍然保持搜索二叉树的性质，怎么删除都无所谓。将`assertEquals`暴露出来，有可能给用户造成一种错误的印象——`assertEquals`等价于检测你的实现是否正确。对于#450这种存在多个正确返回值的题目，