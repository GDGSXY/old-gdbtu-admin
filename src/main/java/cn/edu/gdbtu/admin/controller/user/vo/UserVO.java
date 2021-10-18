package cn.edu.gdbtu.admin.controller.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Data
public class UserVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("用户登录名")
    private String username;

    @ApiModelProperty("角色 id")
    private Long roleId;

}
