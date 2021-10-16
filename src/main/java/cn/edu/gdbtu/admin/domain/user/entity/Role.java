package cn.edu.gdbtu.admin.domain.user.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.user.enums.RoleLevelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    private String name;

    private RoleLevelEnum level;

}
