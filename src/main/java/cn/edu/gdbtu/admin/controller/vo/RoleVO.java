package cn.edu.gdbtu.admin.controller.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Data
@ApiModel("角色信息")
public class RoleVO {

    private Long id;

    private String name;

}
