package com.itchina.test;

import com.itchina.test.service.PoolListMethodServiceImpl;
import com.itchina.test.service.PoolListMethodServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * 线程池处理List两种方式的比较
 */
@RestController
@RequestMapping("/pool")
public class ThreadPoolOperaList2MethodController {


    List<String> stringList = new ArrayList<>();
    @Autowired
    private Executor asyncServiceExecutor;

    /**
     * 耗时 64
     * 正确的
     * */
    @RequestMapping(value = "/m1", method = {RequestMethod.GET, RequestMethod.POST})
    public void test1() {
        asyncServiceExecutor.execute(new PoolListMethodServiceImpl(stringList));
    }
    /**
     * 耗时 338
     * 错误的
     * */
    @RequestMapping(value = "/m2", method = {RequestMethod.GET, RequestMethod.POST})
    public void test2() {
        for (String str : stringList) {
            asyncServiceExecutor.execute(new PoolListMethodServiceImpl2(str));
        }
        

    }

    @RequestMapping(value = "/data", method = {RequestMethod.GET, RequestMethod.POST})
    public void data() {
        for (int i = 0;i< 10000;i++){
            stringList.add("String_" + i);
        }
        System.out.println(stringList.size());
    }


}
