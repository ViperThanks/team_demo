package com.team.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author  : wl
 * email   : vieper0714@outlook.com
 * date     : 2023/3/15 16:53
 * desc     :  简单的用户类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * unique
     */
    private String phone;
    /**
     * 0 女 1 男
     */
    private String sex;
    /**
     * unique
     */
    private String idNumber;
    /**
     * 0 禁用 1 正常
     */
    private Integer status;

    /**
     * 创建时间 用 mp的自动填充
     */
    private LocalDateTime createTime;

}
