package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/ambiguous-coordinates/submissions">leetcode</a>
 */
public class Problem816 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ambiguousCoordinates("(123)"));
        System.out.println(solution.ambiguousCoordinates("(00011)"));
        System.out.println(solution.ambiguousCoordinates("(0123)"));
        System.out.println(solution.ambiguousCoordinates("(100)"));
    }

    static class Solution {
        public List<String> ambiguousCoordinates(String s) {
            //移除前后括号
            s = s.substring(1);
            s = s.substring(0, s.length() - 1);
            Set<Pointer> pointers = new HashSet<>();
            for (int i = 1; i < s.length(); i++) {
                List<String> xs = addPointer(s.substring(0, i));
                List<String> yx = addPointer(s.substring(i));
                for (String x : xs) {
                    for (String y : yx) {
                        pointers.add(new Pointer(x, y));
                    }
                }
            }
            return pointers.stream().filter(Pointer::valid).map(Pointer::toString).collect(Collectors.toList());
        }

        private List<String> addPointer(String s) {
            List<String> result = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            for (int j = 1; j < stringBuilder.length(); j++) {
                stringBuilder.insert(j, ".");
                result.add(stringBuilder.toString());
                stringBuilder.deleteCharAt(j);
            }
            result.add(s);
            return result;
        }

        static class Pointer {
            private final String x;
            private final String y;

            public Pointer(String x, String y) {
                this.x = x;
                this.y = y;
            }

            public boolean valid() {
                return validS(x) && validS(y);
            }

            private boolean validS(String s) {
                if (s.contains(".")) {
                    String[] split = s.split("\\.");
                    if (split[0].length() > 1) {
                        return !split[0].startsWith("0") && !split[1].endsWith("0");
                    }
                    return !split[1].endsWith("0");
                }
                return s.length() <= 1 || !s.startsWith("0");
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o == null || getClass() != o.getClass()) {
                    return false;
                }

                Pointer pointer = (Pointer) o;

                if (!Objects.equals(x, pointer.x)) {
                    return false;
                }
                return Objects.equals(y, pointer.y);
            }

            @Override
            public int hashCode() {
                int result = x != null ? x.hashCode() : 0;
                result = 31 * result + (y != null ? y.hashCode() : 0);
                return result;
            }

            @Override
            public String toString() {
                return "(" + x + ", " + y + ")";
            }
        }
    }
}
