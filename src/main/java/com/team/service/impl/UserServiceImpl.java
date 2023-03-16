package com.team.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team.dao.UserDao;
import com.team.pojo.User;
import com.team.service.UserService;
import org.springframework.stereotype.Service;

/**
 * author  : wl
 * email   : vieper0714@outlook.com
 * date     : 2023/3/15 17:53
 * desc     :
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
