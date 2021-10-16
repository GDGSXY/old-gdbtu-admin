package cn.edu.gdbtu.admin.common.auth;

import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 当前登录的用户
 *
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Data
@Accessors(chain = true)
public class LoginUser {

    private Long id;

    private String username;

    private Role role;

    private List<PermissionEnum> permissions;

}
