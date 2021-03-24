package com.itchina.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date: 2021/3/24 18:24
 * @Desc:
 */
@Mapper
public interface UserRoleMapper {

    List<String>  selectByLoginName(String loginname);

}
