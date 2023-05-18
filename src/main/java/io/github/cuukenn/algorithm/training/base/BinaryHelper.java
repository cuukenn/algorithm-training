package io.github.cuukenn.algorithm.training.base;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author changgg
 */
public class BinaryHelper {
    /**
     * n进制转十进制
     */
    public static BigInteger binary2decimal(int[] binary, int base) {
        BigInteger decimal = BigInteger.ZERO;
        for (int index = 0, length = binary.length; index < length; index++) {
            decimal = decimal.add(BigInteger.valueOf(base).pow(length - index - 1).multiply(BigInteger.valueOf(binary[index])));
        }
        return decimal;
    }

    /**
     * 十进制转n进制
     */
    public static int[] decimal2binary(BigInteger decimal, int base) {
        if (decimal.compareTo(BigInteger.ZERO) == 0) {
            return new int[]{0};
        }
        List<Integer> binaryList = new ArrayList<>();
        final BigInteger baseTmp = BigInteger.valueOf(base), positiveBaseTmp = baseTmp.abs();
        while (decimal.compareTo(BigInteger.ZERO) != 0) {
            BigInteger remain = decimal.remainder(baseTmp);
            if (remain.compareTo(BigInteger.ZERO) < 0) {
                remain = remain.add(positiveBaseTmp);
            }
            binaryList.add(remain.intValue());
            decimal = decimal.subtract(remain).divide(baseTmp);
        }
        Collections.reverse(binaryList);
        return binaryList.stream().mapToInt(binary -> binary).toArray();
    }
}
