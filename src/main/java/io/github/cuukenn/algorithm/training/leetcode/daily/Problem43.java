package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @program: algorithm
 * @description: see：https://leetcode-cn.com/problems/multiply-strings/
 * @author: changgg
 * @create: 2021-02-22 19:22
 **/
public class Problem43 {
  public String multiply(String num1, String num2) {
    int n1 = num1.length() - 1;
    int n2 = num2.length() - 1;
    if (n1 < 0 || n2 < 0) return "";
    int[] mul = new int[n1 + n2 + 2];

    for (int i = n1; i >= 0; --i) {
      for (int j = n2; j >= 0; --j) {
        int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        bitmul += mul[i + j + 1]; // 先加低位判断是否有新的进位

        mul[i + j] += bitmul / 10;
        mul[i + j + 1] = bitmul % 10;
      }
    }
    StringBuilder sb = new StringBuilder();
    int i = 0;
    // 去掉前导0
    while (i < mul.length - 1 && mul[i] == 0)
      i++;
    for (; i < mul.length; ++i)
      sb.append(mul[i]);
    return sb.toString();
  }

  public static void main(String[] args) {
    Problem43 problem43 = new Problem43();
    System.out.println(problem43.multiply("2", "3"));
    System.out.println(problem43.multiply("123", "456"));
    System.out.println(problem43.multiply("999", "999"));
    System.out.println(problem43.multiply("123456789", "987654321"));
    System.out.println(problem43.multiply("123456789", "0"));
    System.out.println(problem43.multiply("999", "9"));
    System.out.println(problem43.multiply("999", "90"));
    System.out.println(problem43.multiply("999", "900"));
  }
}
