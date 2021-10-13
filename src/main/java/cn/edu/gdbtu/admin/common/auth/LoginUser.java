package cn.edu.gdbtu.admin.common.auth;

import lombok.Data;

/**
 * 当前登录的用户
 *
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Data
public class LoginUser {

    private Long id;

    private String username;

    private Long roleId;

}
