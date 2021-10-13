package cn.edu.gdbtu.admin.common.auth;

import cn.edu.gdbtu.admin.common.web.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.annotation.Nonnull;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 授权配置
 *
 * @author Jover Zhang
 * @date 2021/10/13
 */
@RequiredArgsConstructor
public class AuthorizationFilter implements Filter {

    public static final String AUTH_HEADER = "Authorization";

    private static final List<String> SKIP_URIS = Lists.newArrayList();

    static {
        SKIP_URIS.add("/v1/auth");

        // knife4j
        SKIP_URIS.add("/v3/api-docs");
        SKIP_URIS.add("/webjars");
        SKIP_URIS.add("/swagger-resources");
        SKIP_URIS.add("/doc.html");
    }

    private final ObjectMapper objectMapper;

    private final JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Skip uri
        if (isSkipUri(req.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        // Authenticate
        String token = req.getHeader(AUTH_HEADER);
        if (token == null) {
            unAuth(res, "缺少令牌，鉴权失败");
            return;
        }
        if (jwtUtil.parseToken(token) == null) {
            unAuth(res, "鉴权失败");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void unAuth(HttpServletResponse res, String msg) throws IOException {
        res.setStatus(HttpStatus.UNAUTHORIZED.value());
        res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        String rst = objectMapper.writeValueAsString(R.fail(msg));
        res.getWriter().write(rst);
    }

    private boolean isSkipUri(@Nonnull String uri) {
        for (String skipUri : SKIP_URIS) {
            if (uri.startsWith(skipUri)) {
                return true;
            }
        }
        return false;
    }

}
