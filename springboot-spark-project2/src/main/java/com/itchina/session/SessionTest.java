package com.itchina.session;

import com.itchina.common.UserInfoBaseBO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Date: 2021/2/27 17:40
 * @Desc:  session的方式进行登录
 */
@RestController
@RequestMapping("/dev")
public class SessionTest {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String getLogin(String userName, String pasWord, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("loginName", userName + "_" + pasWord);

        /**
         * 测试ThreaadLocal
         * */
        UserInfoBaseBO user = new UserInfoBaseBO();
        user.setId("1000");
        user.setName("雨水");

        session.setAttribute("userInfo",user);
        Cookie cookie = new Cookie("myCookie", userName + "_" + pasWord);
        cookie.setMaxAge(1000);
        cookie.setPath("/");
        //cookie.setDomain("/");
        response.addCookie(cookie);

        return "login successful";
    }


    @RequestMapping(value = "/session", method = {RequestMethod.GET, RequestMethod.POST})
    public String getSession(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Object loginName = session.getAttribute("loginName");

        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println("cookieName  " + cookie.getName() + "  " + cookie.getValue());
            }
        }
        System.out.println("loginName= " + String.valueOf(loginName));
        return  String.valueOf(loginName) ;
    }

}
