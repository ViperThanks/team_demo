package com.team;

import com.team.pojo.User;
import com.team.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * author  : wl
 * email   : vieper0714@outlook.com
 * date     : 2023/3/15 17:55
 * desc     :
 */
@SpringBootTest
@Slf4j
public class ServiceTest {


    @Autowired
    private UserService userService;

    @Test
    void testUserDao() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("122333");
        userService.save(user);
    }


}
