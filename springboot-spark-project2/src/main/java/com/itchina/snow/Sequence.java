package com.itchina.snow;


/**
 * @Date: 2021/4/22 18:12
 * @Desc:
 */
public class Sequence {
    private static int MAX_ID_NUM = 4096;
    private static SnowFlake snowFlake;
    private static Sequence ourInstance = new Sequence();

    public static Sequence getInstance() {
        return ourInstance;
    }

    private Sequence() {
        snowFlake = new SnowFlake(RandomUtil.randomCenterId(), RandomUtil.randomMachineID());
    }

    public long nextId() {
        return snowFlake.nextId();
    }

    public long[] nextIds(int idNum) {
        if (idNum > MAX_ID_NUM) {
            throw new IllegalArgumentException("The number of Id can't be greater than " + MAX_ID_NUM);
        } else {
            long[] ids = new long[idNum];

            for(int i = 0; i < idNum; ++i) {
                ids[i] = snowFlake.nextId();
            }

            return ids;
        }
    }
}
