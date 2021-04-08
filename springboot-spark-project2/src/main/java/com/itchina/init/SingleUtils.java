package com.itchina.init;

import java.util.HashMap;

/**
 * @Date: 2021/3/31 22:52
 * @Desc: 启动时，给单例赋值
 */
public class SingleUtils {
    private SingleUtils() {
    }

    public static HashMap cacgeMap;

    public static HashMap getCacgeMap() {
        return cacgeMap;
    }

    public static void setCacgeMap(HashMap cacgeMap) {
        SingleUtils.cacgeMap = cacgeMap;
    }


}
