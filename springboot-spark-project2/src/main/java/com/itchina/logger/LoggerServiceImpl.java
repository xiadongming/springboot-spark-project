package com.itchina.logger;

import com.alibaba.fastjson.JSONObject;
import com.itchina.bo.LoggerBO;
import com.itchina.mapper.LoggerMapper;
import com.itchina.utils.IPUtils;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Date: 2021/3/12 15:22
 * @Desc:
 */
@Service
public class LoggerServiceImpl implements LoggerService {

    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    private String username = "liudehua";
    @Autowired
    private LoggerMapper loggerMapper;

    @Override
    public void put(JoinPoint joinPoint, String methodName, String module, String description) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            LoggerBO log = new LoggerBO();
            //username = ((JwtClient) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            // 获取当前登录用户
         /*   MyShiroRealm.ShiroUser shiroUser = (MyShiroRealm.ShiroUser) SecurityUtils.getSubject().getPrincipal();
//          User user = userRepository.findOne(shiroUser.getId());
            username = shiroUser.getUsername();
            if (StringUtils.isEmpty(username)) {
                username = Const.USERNAME_IN_CONTEXT != null ? Const.USERNAME_IN_CONTEXT : "未知用户";
            }*/

            String ip = IPUtils.getIpAddr(request);
            log.setUsername(username);
            log.setModule(module);
            log.setDescription(description);
            log.setIp(ip);
            log.setContent(operateContent(joinPoint, methodName, ip, request));
            log.setAble(1);
            log.setCreateAt(new Date());
            log.setUpdateAt(new Date());
            //insert(log);
            loggerMapper.insertDB2(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String operateContent(JoinPoint joinPoint, String methodName, String ip, HttpServletRequest request) throws ClassNotFoundException, NotFoundException {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        Map<String, Object> nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName, params);
        StringBuffer bf = new StringBuffer();
        if (!CollectionUtils.isEmpty(nameAndArgs)) {
            Iterator it = nameAndArgs.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                String value = JSONObject.toJSONString(entry.getValue());
                bf.append(key).append("=");
                bf.append(value).append("&");
            }
        }
        if (StringUtils.isEmpty(bf.toString())) {
            bf.append(request.getQueryString());
        }
        return String.format(LOG_CONTENT, className, methodName, bf.toString(), ip);
    }

    private Map<String, Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws NotFoundException {
        Map<String, Object> map = new HashMap<String, Object>();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
            return map;
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++) {
            //paramNames即参数名
            map.put(attr.variableName(i + pos), args[i]);
        }
        return map;
    }
}
