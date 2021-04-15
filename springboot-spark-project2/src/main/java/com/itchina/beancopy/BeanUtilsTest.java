package com.itchina.beancopy;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/4/12 18:19
 * @Desc:
 */
public class BeanUtilsTest {


    public static void main(String[] args) {
        BasePO1 basePO1 = new BasePO1();
        BasePO2 basePO2 = new BasePO2();

        basePO1.setName("111");
        basePO1.setAddr("222");
        UsreInfo1 usreInfo1 = new UsreInfo1();
        usreInfo1.setUserName("vvvvv");
        usreInfo1.setUserAddr("mmmmm");
        usreInfo1.setAge("25");
        List<UsreInfo1> userInfolist1 = new ArrayList<>();
        userInfolist1.add(usreInfo1);



        basePO1.setUserInfolist(userInfolist1);

        List<UsreInfo3> userInfolist3 = new ArrayList<>();
        UsreInfo3 usreInfo3 = new UsreInfo3();
        usreInfo3.setAge("1000000");
        userInfolist3.add(usreInfo3);
        basePO1.setUserInfolist3(userInfolist3);


        BeanUtils.copyProperties(basePO1,basePO2);

        System.out.println(basePO2);

    }

}
