package cn.edu.gdbtu.admin.config;

import cn.edu.gdbtu.admin.common.auth.AuthenticationInterceptor;
import cn.edu.gdbtu.admin.common.auth.AuthorizationFilter;
import cn.edu.gdbtu.admin.common.auth.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Configuration
@RequiredArgsConstructor
public class AuthorizationConfiguration implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    @Bean
    public AuthorizationFilter authorizationFilter() {
        return new AuthorizationFilter(objectMapper, jwtUtil());
    }

    @Bean
    public JwtUtil jwtUtil() {
        JwtUtil.setSingleton(new JwtUtil(null, null, objectMapper));
        return JwtUtil.getSingleton();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthenticationInterceptor(objectMapper));
    }

}
