package com.itchina.jingdu;

import java.math.BigDecimal;

/**
 * @Date: 2021/4/12 16:56
 * @Desc:
 */
public class JingDuTest {
    public static void main(String[] args) {
        /**
         * dubbo/Dubbo  会精度丢失，不能作为金额的操作
         * BigDecimal   1-浮点数精确表达和运算的场景，一定要使用这个类型
         *              2-使用 BigDecimal 时有几个坑需要避开。我们用 BigDecimal 把之前的四则运算改
         *              3-使用 BigDecimal 表示和计算浮点数，且务必使用字符串的构造方法来初始化BigDecimal
         *              4-BigDecimal比较大小不能是equals和==，只能使用 compareTo()
         *                                    1   大于
         *                                    0   相等
         *                                   -1   小于
         */
        System.out.println(0.1 + 0.2);
        System.out.println(1.0 - 0.8);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);

        /**
         * BigDecimal 的加减乘除
         * */
        System.out.println("===========分界线============");
        System.out.println("====BigDecimal的错误案例如下====start=======");
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.2)));
        System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.8)));
        System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)));
        System.out.println(new BigDecimal(123.3).divide(new BigDecimal(100)));
        System.out.println();
        System.out.println("====BigDecimal的正确案例如下====start=======");
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        System.out.println(new BigDecimal("1.0").subtract(new BigDecimal("0.8")));
        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal("100")));
        System.out.println(new BigDecimal("123.3").divide(new BigDecimal("100")));

        System.out.println();
        System.out.println("====Double转为BigDecimal的正确案例====start=======");
        System.out.println(new BigDecimal("4.015").multiply(BigDecimal.valueOf(100)));
        System.out.println(new BigDecimal("4.015"));
        Double value1 = 200.01;
        Double value2 = 200.01;
        BigDecimal bigDecimal = BigDecimal.valueOf(value1);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(value2);
        System.out.println(bigDecimal.add(bigDecimal1));

        System.out.println();
        System.out.println("====BigDecimal比较大小=======start=======");
        BigDecimal bigDecimal2 = new BigDecimal("0.1");
        BigDecimal bigDecimal3 = new BigDecimal("0.10");
        BigDecimal bigDecimal4 = new BigDecimal("0.40");
        System.out.println(bigDecimal2.equals(bigDecimal3));
        System.out.println(bigDecimal2.compareTo(bigDecimal3));
        System.out.println(bigDecimal4.compareTo(bigDecimal3));
        System.out.println(bigDecimal2.compareTo(bigDecimal4));

    }
}
