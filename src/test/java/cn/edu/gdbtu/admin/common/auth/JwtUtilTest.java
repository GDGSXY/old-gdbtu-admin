package cn.edu.gdbtu.admin.common.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JwtUtilTest extends Assertions {

    @Test
    void testToken() throws InterruptedException {
        JwtUtil jwtUtil = new JwtUtil(null, 2);
        {
            String subject = "123";
            String token = jwtUtil.generateToken(subject);
            assertEquals(subject, jwtUtil.parseToken(token, String.class));
        }
        {
            String subject = "123";
            String token = jwtUtil.generateToken(subject);
            Thread.sleep(2500L);
            assertThrows(ExpiredJwtException.class, () -> jwtUtil.parseToken(token));
        }
        {
            Obj subject = new Obj(1L, "abc");
            String token = jwtUtil.generateToken(subject);
            assertEquals(subject, jwtUtil.parseToken(token, Obj.class));
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Obj {

        private Long id;

        private String name;

    }

}
