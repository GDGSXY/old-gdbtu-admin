package cn.edu.gdbtu.admin.common.auth;

import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;

import java.lang.annotation.*;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredPermission {

    PermissionEnum[] value();

}
