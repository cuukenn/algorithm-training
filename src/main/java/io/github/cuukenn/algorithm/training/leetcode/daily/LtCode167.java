package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&id=top-interview-150">leetcode167</a>
 */
public class LtCode167 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //1,2
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        //1,3
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4}, 6)));
        //1,2
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1, 0}, -1)));
    }

    static class Solution {
        //正常遍历
        public int[] twoSum1(int[] numbers, int target) {
            for (int index = 1; index < numbers.length; index++) {
                int index1 = index - 1, index2 = index;
                while (index2 < numbers.length) {
                    if (numbers[index1] + numbers[index2] == target) {
                        return new int[]{index1 + 1, index2 + 1};
                    } else if (numbers[index1] + numbers[index2] > target) {
                        break;
                    } else {
                        index2++;
                    }
                }
            }
            return new int[0];
        }

        //java二分遍历
        public int[] twoSum2(int[] numbers, int target) {
            for (int index = 1; index < numbers.length; index++) {
                int endIndex = Arrays.binarySearch(numbers, index, numbers.length, target - numbers[index - 1]);
                if (endIndex >= 0) {
                    return new int[]{index, endIndex + 1};
                }
            }
            return new int[0];
        }

        //手写二分遍历
        public int[] twoSum(int[] numbers, int target) {
            for (int index = 0; index < numbers.length; index++) {
                int startIndex = index + 1, endIndex = numbers.length - 1;
                while (startIndex <= endIndex) {
                    int mid = startIndex + ((endIndex - startIndex) >> 1);
                    if (numbers[mid] + numbers[index] == target) {
                        return new int[]{index + 1, mid + 1};
                    } else if (numbers[mid] + numbers[index] > target) {
                        endIndex = mid - 1;
                    } else {
                        startIndex = mid + 1;
                    }
                }
            }
            return new int[0];
        }
    }
}
