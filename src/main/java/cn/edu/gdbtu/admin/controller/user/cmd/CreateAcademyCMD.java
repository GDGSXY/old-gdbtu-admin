package cn.edu.gdbtu.admin.controller.user.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateAcademyCMD {

    @NotNull
    @ApiModelProperty(value = "学院名称", required = true)
    private String name;
}
