package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.user.AuthService;
import cn.edu.gdbtu.admin.service.user.PermissionService;
import cn.edu.gdbtu.admin.service.user.RoleService;
import cn.edu.gdbtu.admin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final RoleService roleService;

    private final PermissionService permissionService;

    @Override
    public LoginUser login(String username, String password) {
        // 密码校验
        User user = userService.getByUsername(username);
        if (user == null || !password.equals(user.getPassword())) {
            throw new IllegalArgumentException("用户或密码不正确");
        }
        // 获取角色
        Role role = roleService.getById(user.getRoleId());
        // 获取权限
        List<PermissionEnum> permissions = permissionService.getPermissionsByRoleId(role.getId());
        // 登录权限校验
        if (!permissions.contains(PermissionEnum.ADMIN_SYSTEM)) {
            throw new IllegalArgumentException("没有 Admin 系统的登录权限");
        }
        return new LoginUser()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setRole(role)
                .setPermissions(permissions);
    }

}
