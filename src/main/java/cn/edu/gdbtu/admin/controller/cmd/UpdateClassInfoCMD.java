package cn.edu.gdbtu.admin.controller.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author Jover Zhang
 * @date 2021/10/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateClassInfoCMD extends CreateClassInfoCMD {

    @NotNull
    @ApiModelProperty(value = "id", required = true)
    private Long id;

}
