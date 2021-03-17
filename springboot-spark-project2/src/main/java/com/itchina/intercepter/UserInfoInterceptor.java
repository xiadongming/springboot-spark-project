package com.itchina.intercepter;

import com.itchina.common.UserInfoBaseBO;
import com.itchina.globaluserinfo.UserContextHolderThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date: 2021/3/17 14:31
 * @Desc: 用于过滤session中的用户信息
 *       :在 afterCompletion 中需要清除ThreadLocal,即一个请求完成以后销毁 ThreadLocal
 */
public class UserInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfoBaseBO user = (UserInfoBaseBO) request.getSession().getAttribute("userInfo");
        if (user != null) {
            UserContextHolderThreadLocal.setCurrentUser(user);
            return true;
        }
        return false;
    }

    /**
     *
     * 每个请求都是在一个线程里完成的
     * 每一次的请求会产生一个新的Thread吗?
     * 不会，Tomcat会维护一个托管线程池，多次请求间可能会用到一个线程
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextHolderThreadLocal.removeCurrentUser();
    }
}
