package com.itchina.collection;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Date: 2021/4/18 21:53
 * @Desc:
 */

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();
        Collections.synchronizedList(arrayList);

        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.get(1);
    }


}
