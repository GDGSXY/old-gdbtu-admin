package cn.edu.gdbtu.admin.controller.user.vo;

import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Data
@ApiModel("登录用户信息")
public class LoginUserVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("角色")
    private RoleVO role;

    @ApiModelProperty("权限列表")
    private List<PermissionEnum> permissions;

    @ApiModelProperty("token")
    private String token;

}

