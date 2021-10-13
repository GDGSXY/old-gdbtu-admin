package cn.edu.gdbtu.admin.common.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

/**
 * JWT 工具
 *
 * @author Jover Zhang
 * @date 2021/10/13
 */
public class JwtUtil {

    private static final String DEFAULT_SIGNING_KEY = "ajdsfklheirosadfkljlahgauoweraysadfkhjlzxvcbnm";

    private static final int DEFAULT_EXPIRATION_INTERVAL = 60 * 60 * 12;

    private static @Getter @Setter JwtUtil singleton;

    private final int expirationInterval;

    private final ObjectMapper objectMapper;

    private final JwtBuilder jwtBuilder;

    private final JwtParser jwtParser;

    public JwtUtil(@Nullable String singingKey, @Nullable Integer expirationInterval) {
        this(singingKey, expirationInterval, new ObjectMapper());
    }

    public JwtUtil(@Nullable String singingKey, @Nullable Integer expirationInterval, @Nonnull ObjectMapper objectMapper) {
        String key = Optional.ofNullable(singingKey).orElse(DEFAULT_SIGNING_KEY);
        this.expirationInterval = Optional.ofNullable(expirationInterval).orElse(DEFAULT_EXPIRATION_INTERVAL);
        this.objectMapper = objectMapper;
        this.jwtBuilder = Jwts.builder().signWith(SignatureAlgorithm.HS512, key);
        this.jwtParser = Jwts.parser().setSigningKey(key);
    }

    /**
     * 生成 token
     */
    public String generateToken(Object subject) {
        try {
            String str = objectMapper.writeValueAsString(subject);
            return generateToken(str);
        } catch (JsonProcessingException e) {
            throw new CompressionException(e.getMessage(), e);
        }
    }

    /**
     * 解析 token
     */
    public <T> T parseToken(String token, Class<T> clazz) {
        String subject = parseToken(token).get(Claims.SUBJECT, String.class);
        try {
            return objectMapper.readValue(subject, clazz);
        } catch (JsonProcessingException e) {
            throw new JwtException(e.getMessage(), e);
        }
    }

    /**
     * 生成 token
     */
    public String generateToken(String subject) {
        return jwtBuilder
                .setSubject(subject)
                .setExpiration(getExpiration())
                .compact();
    }

    /**
     * 解析 token
     */
    public Claims parseToken(String token) {
        return jwtParser
                .parseClaimsJws(token)
                .getBody();
    }

    private Date getExpiration() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, expirationInterval);
        return calendar.getTime();
    }

}
