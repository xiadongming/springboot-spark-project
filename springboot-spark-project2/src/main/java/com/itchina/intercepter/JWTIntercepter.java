package com.itchina.intercepter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @Date: 2021/2/27 21:27
 * @Desc: JWT拦截器
 */
@Component
public class JWTIntercepter extends HandlerInterceptorAdapter {


    private static final String JWT_KEY = "jwt_key_xia";
    private static final String JWT_TOKEN = "jwt_token_xia";
    private static final String UID = "jwt_uid";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("token为空");
        }
        Algorithm miyao = null;
        try {
            miyao = Algorithm.HMAC256("miyao");
            JWTVerifier verifier = JWT.require(miyao).build();
            DecodedJWT jwt = verifier.verify(token);
            request.setAttribute("userIdFromHandle",jwt.getClaim("id").asString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       return true;
    }
}
