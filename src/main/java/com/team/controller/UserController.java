package com.team.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.team.common.Result;
import com.team.pojo.User;
import com.team.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * author  : wl
 * email   : vieper0714@outlook.com
 * date     : 2023/3/15 19:58
 * desc     :
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        if ( !(StringUtils.hasLength(username) && StringUtils.hasLength(password)) ){
            return Result.error("请填账号或者密码!!!");
        }

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getPassword,password);
        lqw.eq(User::getUsername,username);

        User one = userService.getOne(lqw);
        if (one == null){
            return Result.error("账号或者密码错误!!");
        }

        //
        session.setAttribute("user",one);


        //暂时传字符串,以后代码以后说

        return Result.success("登录成功");
    }

}
