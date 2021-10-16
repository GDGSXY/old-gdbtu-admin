package cn.edu.gdbtu.admin.common.auth;

import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限校验拦截器
 *
 * @author Jover Zhang
 * @date 2021/10/16
 */
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @Override
    public boolean preHandle(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse res, @Nonnull Object handler) throws Exception {
        if (handler instanceof HandlerMethod method) {
            RequiredPermission annotation = AnnotatedElementUtils.getMergedAnnotation(method.getBeanType(), RequiredPermission.class);
            if (annotation == null && (annotation = method.getMethodAnnotation(RequiredPermission.class)) == null) {
                return true;
            }
            if (userContainsPermissions(annotation.value())) {
                return true;
            }
            return fail(res);
        }
        return true;
    }

    private boolean userContainsPermissions(PermissionEnum[] requiredPermissions) {
        LoginUser user = AuthUtil.getUser();
        for (PermissionEnum requiredPermission : requiredPermissions) {
            if (!user.getPermissions().contains(requiredPermission)) {
                return false;
            }
        }
        return true;
    }

    private boolean fail(HttpServletResponse res) throws IOException {
        res.setStatus(HttpStatus.BAD_REQUEST.value());
        res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        String rst = objectMapper.writeValueAsString(R.fail("缺少权限，鉴权失败"));
        res.getWriter().write(rst);
        return false;
    }

}
