package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.service.user.AuthService;
import cn.edu.gdbtu.admin.service.user.RoleService;
import cn.edu.gdbtu.admin.service.user.UserService;
import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final RoleService roleService;

    @Override
    public LoginUser login(String username, String password) {
        User user = userService.getByUsername(username);
        if (user == null || !password.equals(user.getPassword())) {
            throw new IllegalArgumentException("用户或密码不正确");
        }

        Role role = roleService.getById(user.getRoleId());
        Preconditions.checkNotNull(role);
        return new LoginUser()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setRole(role);
    }

}
