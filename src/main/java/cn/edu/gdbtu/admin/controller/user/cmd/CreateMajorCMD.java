package cn.edu.gdbtu.admin.controller.user.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateMajorCMD {

    @NotNull
    @ApiModelProperty(value = "专业名称", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "学院 id", required = true)
    private Long academyId;
}
