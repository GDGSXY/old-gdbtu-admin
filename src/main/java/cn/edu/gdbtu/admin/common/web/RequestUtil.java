package cn.edu.gdbtu.admin.common.web;

import com.google.common.base.Preconditions;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
public interface RequestUtil {

    static HttpServletRequest getRequest() {
        ServletRequestAttributes req = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Preconditions.checkNotNull(req);
        return req.getRequest();
    }

    static HttpServletResponse getResponse() {
        ServletWebRequest req = (ServletWebRequest) RequestContextHolder.getRequestAttributes();
        Preconditions.checkNotNull(req);
        return req.getResponse();
    }

}
