package cn.edu.gdbtu.admin.domain.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.enums.RoleTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色信息
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 父角色 id
     */
    private Long parentRoleId;

    /**
     * 角色类型
     */
    private RoleTypeEnum type;

    /**
     * 是否允许登录管理系统
     */
    private Boolean allowLoginManage;

}
