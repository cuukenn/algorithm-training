package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/online-stock-span/">leetcode</a>
 */
public class Problem901 {
    public static void main(String[] args) {
        {
            StockSpanner solve = new Problem901.StockSpanner();
            System.out.println(solve.next(100));
            System.out.println(solve.next(80));
            System.out.println(solve.next(60));
            System.out.println(solve.next(70));
            System.out.println(solve.next(60));
            System.out.println(solve.next(75));
            System.out.println(solve.next(85));
        }
        System.out.println();
        {
            StockSpanner solve = new Problem901.StockSpanner();
            System.out.println(solve.next(1));
            System.out.println(solve.next(2));
            System.out.println(solve.next(3));
            System.out.println(solve.next(4));
            System.out.println(solve.next(5));
        }
        System.out.println();
        {
            StockSpanner solve = new Problem901.StockSpanner();
            System.out.println(solve.next(28));
            System.out.println(solve.next(14));
            System.out.println(solve.next(28));
            System.out.println(solve.next(35));
            System.out.println(solve.next(46));
            System.out.println(solve.next(53));
            System.out.println(solve.next(66));
            System.out.println(solve.next(80));
            System.out.println(solve.next(87));
            System.out.println(solve.next(88));
        }
    }

    public static class StockSpanner {
        private final Stack<Integer> pricesIndex;
        private final List<Integer> prices;

        public StockSpanner() {
            pricesIndex = new Stack<>();
            prices = new LinkedList<>();
        }

        public int next(int price) {
            while (!pricesIndex.isEmpty() && prices.get(pricesIndex.peek()) <= price) {
                pricesIndex.pop();
            }
            int lastIndex = !pricesIndex.isEmpty() ? pricesIndex.peek() : -1;
            prices.add(price);
            pricesIndex.add(prices.size() - 1);
            return prices.size() - lastIndex - 1;
        }
    }
}
