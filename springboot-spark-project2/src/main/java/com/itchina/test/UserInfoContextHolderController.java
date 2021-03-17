package com.itchina.test;

import com.itchina.common.UserInfoBaseBO;
import com.itchina.globaluserinfo.UserContextHolderThreadLocal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/17 14:43
 * @Desc:
 */
@RestController
@RequestMapping("/dev")
public class UserInfoContextHolderController {

    @RequestMapping(value = "/userHolder",method = {RequestMethod.GET,RequestMethod.POST})
    public Object getTest1(){
        UserInfoBaseBO currentUser = UserContextHolderThreadLocal.getCurrentUser();
        System.out.println("currentUser= "+currentUser);
        return currentUser;
    }


}
