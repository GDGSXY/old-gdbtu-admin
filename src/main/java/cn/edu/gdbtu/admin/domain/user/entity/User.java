package cn.edu.gdbtu.admin.domain.user.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    private String username;

    private String password;

    private String salt;

    private Long roleId;

}
