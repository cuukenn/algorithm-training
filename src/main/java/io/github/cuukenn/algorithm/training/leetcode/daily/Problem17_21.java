package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author changgg
 * @Classname Problem17_21
 * @Description https://leetcode-cn.com/problems/volume-of-histogram-lcci/submissions/
 * @Date 2021/4/2 19:57
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem17_21 {
    public int trap(int[] height) {
        List<Integer[]> ranges = new ArrayList<>();
        for (int index = 0; index < height.length; index++) {
            int left = index, right = index;
            while (left >= 0 && height[left] <= height[index]) {
                left--;
            }
            while (right < height.length && height[right] <= height[index]) {
                right++;
            }
            if (left >= 0 && right < height.length
                    && left < index && right > index) {
                boolean hasBig = false;
                Iterator<Integer[]> iterator = ranges.iterator();
                while (iterator.hasNext()) {
                    Integer[] range = iterator.next();
                    if (range[0] <= left && range[1] >= right) {
                        hasBig = true;
                    } else if (range[0] >= left && range[1] <= right) {
                        iterator.remove();
                    }
                }
                if (!hasBig) {
                    ranges.add(new Integer[]{left, right});
                }
            }
        }
        Set<String> hasExecute = new HashSet<>();
        int rs = 0;
        for (Integer[] range : ranges) {
            String value = range[0] + "_" + range[1];
            if (!hasExecute.contains(value)) {
                rs += (range[1] - range[0] - 1) * Math.min(height[range[0]], height[range[1]]);
                for (int index = range[0] + 1; index < range[1]; index++) {
                    rs -= height[index];
                }
                hasExecute.add(value);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem17_21 problem17_21 = new Problem17_21();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(problem17_21.trap(height));
        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(problem17_21.trap(height));
    }
}
