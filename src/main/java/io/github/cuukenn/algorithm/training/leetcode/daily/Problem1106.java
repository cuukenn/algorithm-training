package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/parsing-a-boolean-expression/submissions/">leetcode</a>
 */
public class Problem1106 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.parseBoolExpr("!(f)"));
        System.out.println(solution.parseBoolExpr("|(f,t)"));
        System.out.println(solution.parseBoolExpr("&(f,t)"));
        System.out.println(solution.parseBoolExpr("|(&(t,f,t),!(t))"));
        System.out.println(solution.parseBoolExpr("|(f,&(t,t))"));
    }

    static class Solution {
        public boolean parseBoolExpr(String expression) {
            final Expression exp = parseExpression(expression);
            return exp.getResult();
        }

        private Expression parseExpression(String expression) {
            Expression exp = new SimpleExpression();
            final char[] chars = expression.toCharArray();
            Stack<Expression> expressions = new Stack<>();
            expressions.push(exp);
            for (char c : chars) {
                if (c == '&') {
                    Expression expLocal = new AndExpression();
                    expressions.peek().addExpression(expLocal);
                    expressions.push(expLocal);
                } else if (c == '|') {
                    Expression expLocal = new OrExpression();
                    expressions.peek().addExpression(expLocal);
                    expressions.push(expLocal);
                } else if (c == '!') {
                    Expression expLocal = new NotExpression();
                    expressions.peek().addExpression(expLocal);
                    expressions.push(expLocal);
                } else if (c == ')') {
                    expressions.pop();
                } else if (c == 't' || c == 'f') {
                    expressions.peek().addExpression(new BooleanExpression(c + ""));
                }
            }
            return exp;
        }

        interface Expression {
            /**
             * 添加子表达式
             *
             * @param expression 表达式
             */
            void addExpression(Expression expression);

            /**
             * 获取结果
             *
             * @return 解析表达式
             */
            boolean getResult();
        }

        static class AndExpression implements Expression {
            private final List<Expression> expressions = new LinkedList<>();

            @Override
            public void addExpression(Expression expression) {
                expressions.add(expression);
            }

            @Override
            public boolean getResult() {
                return expressions.stream().allMatch(Expression::getResult);
            }
        }

        static class OrExpression implements Expression {
            private final List<Expression> expressions = new LinkedList<>();

            @Override
            public void addExpression(Expression expression) {
                expressions.add(expression);
            }

            @Override
            public boolean getResult() {
                return expressions.stream().anyMatch(Expression::getResult);
            }
        }

        static class NotExpression implements Expression {
            private Expression expression;

            @Override
            public void addExpression(Expression expression) {
                this.expression = expression;
            }

            @Override
            public boolean getResult() {
                return !expression.getResult();
            }
        }

        static class BooleanExpression implements Expression {
            private final String str;

            public BooleanExpression(String str) {
                this.str = str;
            }

            @Override
            public void addExpression(Expression expression) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean getResult() {
                return "t".equals(str);
            }
        }

        static class SimpleExpression implements Expression {
            private Expression expression;

            @Override
            public void addExpression(Expression expression) {
                this.expression = expression;
            }

            @Override
            public boolean getResult() {
                return expression.getResult();
            }
        }
    }
}
