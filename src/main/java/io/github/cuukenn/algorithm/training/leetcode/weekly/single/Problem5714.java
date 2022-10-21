package io.github.cuukenn.algorithm.training.leetcode.weekly.single;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author changgg
 * @Classname Problem5714
 * @Description https://leetcode-cn.com/contest/weekly-contest-234/problems/evaluate-the-bracket-pairs-of-a-string/
 * @Date 2021/3/28 10:57
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5714 {
    public String evaluate(String s, List<List<String>> knowledge) {
        final Map<String, String> properties = new HashMap<>();
        for (List<String> k : knowledge) {
            properties.put(k.get(0), k.get(1));
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder tmpKey = new StringBuilder();
        boolean isKey = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                isKey = true;
            } else if (c == ')') {
                sb.append(properties.getOrDefault(tmpKey.toString(), "?"));
                tmpKey = new StringBuilder();
                isKey = false;
            } else {
                if (isKey) {
                    tmpKey.append(c);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem5714 problem5714 = new Problem5714();
        System.out.println(problem5714.evaluate("(name)is(age)yearsold",
                Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"))));
        System.out.println(problem5714.evaluate("hi(name)",
                Arrays.asList(Arrays.asList("a", "a"))));
        System.out.println(problem5714.evaluate("(a)(a)(a)aaa",
                Arrays.asList(Arrays.asList("a", "yes"))));
        System.out.println(problem5714.evaluate("(a)(b)",
                Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "a"))));
    }
}
