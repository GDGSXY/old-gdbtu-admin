package cn.edu.gdbtu.admin.common.entity;

import org.mapstruct.Mapping;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@Mapping(target = "gmtCreate", ignore = true)
@Mapping(target = "gmtModified", ignore = true)
@Mapping(target = "deleted", ignore = true)
public @interface IgnoreToBaseEntity {
}
