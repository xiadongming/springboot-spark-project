package com.itchina.snow;

import java.util.Random;

/**
 * @Date: 2021/4/22 18:13
 * @Desc:
 */
public class RandomUtil {
    private static final int MAX_CENTER_ID = 4;
    private static final int MAX_MACHINE_ID = 16;

    public RandomUtil() {
    }

    public static long randomCenterId() {
        return (long)(new Random((new Random()).nextLong())).nextInt(4);
    }

    public static long randomMachineID() {
        return (long)(new Random((new Random()).nextLong())).nextInt(16);
    }
}
