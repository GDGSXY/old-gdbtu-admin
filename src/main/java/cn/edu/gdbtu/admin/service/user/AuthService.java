package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.auth.LoginUser;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface AuthService {

    LoginUser login(String username, String password);

}
