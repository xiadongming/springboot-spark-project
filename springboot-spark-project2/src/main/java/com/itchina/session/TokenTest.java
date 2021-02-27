package com.itchina.session;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Date: 2021/2/27 18:43
 * @Desc:  jwt即token的登录和验证流程
 */
@RestController
@RequestMapping("/dev")
public class TokenTest {

    @RequestMapping(value = "/jwtLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String getLogin(String userName, String pasWord, HttpServletResponse response) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("miyao");
            token = JWT.create().withIssuer("managerRole").withExpiresAt(new Date(System.currentTimeMillis() + 3600000)).sign(algorithm);
            //1h过期时间

            response.setHeader("token", token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 验证token
     */
    @RequestMapping(value = "/infoWithJWT", method = {RequestMethod.GET, RequestMethod.POST})
    public DecodedJWT getLogin(@RequestHeader String token) {
        DecodedJWT verify = null;
        try {
            Algorithm miyao = Algorithm.HMAC256("miyao");
            JWTVerifier verifier = JWT.require(miyao).withIssuer("managerRole").build();
            verify = verifier.verify(token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Header= " + verify.getHeader());
        System.out.println("Payload= " + verify.getPayload());
        System.out.println("Signature= " + verify.getSignature());
        System.out.println("Token= " + verify.getToken());

        return verify;
    }

}
