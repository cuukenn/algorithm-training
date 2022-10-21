package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author changgg
 * @Classname Problem341
 * @Description https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * @Date 2021/3/23 19:18
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem341 {
    public static void main(String[] args) {
        Problem341 problem341 = new Problem341();
    }

    private static class NestedIterator implements Iterator<Integer> {
        private final Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.iterator = this.dsf(new ArrayList<>(), nestedList).listIterator();
        }

        private List<Integer> dsf(List<Integer> rs, List<NestedInteger> nestedList) {
            if (nestedList.isEmpty()) {
                return rs;
            }
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    rs.add(nestedInteger.getInteger());
                } else {
                    dsf(rs, nestedInteger.getList());
                }
            }
            return rs;
        }


        @Override
        public Integer next() {
            return this.iterator.next();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }
    }

    private static interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
