package cn.edu.gdbtu.admin.domain.user.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity {

    private Long roleId;

    private String accessResource;

}
