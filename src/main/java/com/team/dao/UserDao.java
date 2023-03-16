package com.team.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * author  : wl
 * email   : vieper0714@outlook.com
 * date     : 2023/3/15 17:45
 * desc     :
 */

@Mapper
public interface UserDao extends BaseMapper<User> {
}
