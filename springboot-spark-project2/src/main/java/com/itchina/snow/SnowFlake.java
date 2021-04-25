package com.itchina.snow;

/**
 * @Date: 2021/4/22 18:12
 * @Desc:
 */
public class SnowFlake {
    private static final long START_STMP = 1480166465631L;
    private static final long SEQUENCE_BIT = 4L;
    private static final long MACHINE_BIT = 4L;
    private static final long DATACENTER_BIT = 2L;
    private static final long MAX_DATACENTER_NUM = 3L;
    private static final long MAX_MACHINE_NUM = 15L;
    private static final long MAX_SEQUENCE = 15L;
    private static final long MACHINE_LEFT = 4L;
    private static final long DATACENTER_LEFT = 8L;
    private static final long TIMESTMP_LEFT = 10L;
    private long datacenterId;
    private long machineId;
    private long sequence = 0L;
    private long lastStmp = -1L;

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId <= 3L && datacenterId >= 0L) {
            if (machineId <= 15L && machineId >= 0L) {
                this.datacenterId = datacenterId;
                this.machineId = machineId;
            } else {
                throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
            }
        } else {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
    }

    public synchronized long nextId() {
        long currStmp = this.getNewstmp();
        if (currStmp < this.lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        } else {
            if (currStmp == this.lastStmp) {
                this.sequence = this.sequence + 1L & 18L;
                if (this.sequence == 0L) {
                    currStmp = this.getNextMill();
                }
            } else {
                this.sequence = 0L;
            }
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("currStmp= " + currStmp);
            System.out.println("currStmp - 1480166465631L << 10 " + (currStmp - 1480166465631L << 10));
            System.out.println("this.datacenterId << 8 " + (this.datacenterId << 8));
            System.out.println("this.machineId << 4 " + (this.machineId << 4));
            System.out.println("this.sequence " + (this.sequence));

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
            this.lastStmp = currStmp;
            return currStmp - 1480166465631L << 10 | this.datacenterId << 8 | this.machineId << 4 | this.sequence;
        }
    }

    private long getNextMill() {
        long mill;
        for(mill = this.getNewstmp(); mill <= this.lastStmp; mill = this.getNewstmp()) {
        }

        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake(2L, 3L);

        for(int i = 0; i < 4096; ++i) {
            System.out.println(snowFlake.nextId());
        }

    }
}
