package cn.edu.gdbtu.admin.controller.user.cmd;

import cn.edu.gdbtu.admin.domain.user.enums.RoleLevelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Jover Zhang
 * @date 2021/10/18
 */
@Data
public class CreateRoleCMD {

    @NotNull
    @ApiModelProperty(value = "角色名称", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "角色职级", required = true)
    private RoleLevelEnum level;

}
