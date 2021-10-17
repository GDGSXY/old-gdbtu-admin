package cn.edu.gdbtu.admin.config.web;

import cn.edu.gdbtu.admin.common.web.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Configuration
@RestControllerAdvice
public class GlobalExceptionConfiguration {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R<Void> handleIllegalArgumentException(Exception exception) {
        return R.fail(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public R<Void> handleExceptions(Exception exception) {
        return R.fail(exception.getMessage());
    }

}
