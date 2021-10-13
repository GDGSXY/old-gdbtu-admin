package cn.edu.gdbtu.admin.common.auth;

import cn.edu.gdbtu.admin.common.web.RequestUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 授权工具
 *
 * @author Jover Zhang
 * @date 2021/10/13
 */
public interface AuthUtil {

    static LoginUser getUser() {
        HttpServletRequest request = RequestUtil.getRequest();
        String token = request.getHeader(AuthorizationFilter.AUTH_HEADER);
        return JwtUtil.getSingleton().parseToken(token, LoginUser.class);
    }

}
