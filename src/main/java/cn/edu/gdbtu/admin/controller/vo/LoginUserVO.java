package cn.edu.gdbtu.admin.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    @ApiModelProperty("角色 id")
    private RoleVO role;

    @ApiModelProperty("token")
    private String token;

}

