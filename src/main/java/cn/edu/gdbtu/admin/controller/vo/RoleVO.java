package cn.edu.gdbtu.admin.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Data
@ApiModel("角色信息")
public class RoleVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("角色名称")
    private String name;

}
