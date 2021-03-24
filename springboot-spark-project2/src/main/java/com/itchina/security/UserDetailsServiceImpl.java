package com.itchina.security;

import com.itchina.mapper.UserRoleMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/3/24 11:39
 * @Desc:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {        // 这里可以捕获异常，使用异常映射，抛出指定的提示信息
        // 用户校验的操作
        // 假设密码是数据库查询的 123
        List<String> roleList = userRoleMapper.selectByLoginName(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        /*
         * Spring Boot 2.0 版本踩坑
         * 必须要 ROLE_ 前缀， 因为 hasRole("LEVEL1")判断时会自动加上ROLE_前缀变成 ROLE_LEVEL1 ,
         * 如果不加前缀一般就会出现403错误
         * 在给用户赋权限时,数据库存储必须是完整的权限标识ROLE_LEVEL1
         */
        if (roleList != null && roleList.size() > 0) {
            for (String role : roleList) {
                grantedAuthorityList.add(new SimpleGrantedAuthority(role));
            }
        }
        MyUserInfoDetailBO myUserInfoDetailBO = new MyUserInfoDetailBO();
        myUserInfoDetailBO.setGrantedAuthorityList(grantedAuthorityList);
        return myUserInfoDetailBO;
    }
}
