package com.itchina.test.async;

import com.itchina.asyncrequest.AsyncRequestOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Date: 2021/3/31 21:34
 * @Desc:
 */
@RestController
@RequestMapping(value = "/async")
public class AsyncController {

    @Autowired
    private AsyncRequestOne asyncRequestOne ;

    @RequestMapping(value = "/async",method = {RequestMethod.GET,RequestMethod.POST})
    public Object  getTest() throws InterruptedException {
        System.out.println("controller====>>>"+Thread.currentThread().getName());
        asyncRequestOne.asyncRequest();

        return "successful";
    }

    @RequestMapping(value = "/async2",method = {RequestMethod.GET,RequestMethod.POST})
    public Object  getTest2() throws ExecutionException, InterruptedException {
        System.out.println("controller====>>>"+Thread.currentThread().getName());
        Future<String> stringFuture = asyncRequestOne.asyncFutureRsp();
        String s = stringFuture.get();
        return s;
    }
}
