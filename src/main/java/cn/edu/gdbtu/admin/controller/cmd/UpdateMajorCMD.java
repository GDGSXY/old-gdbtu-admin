package cn.edu.gdbtu.admin.controller.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateMajorCMD extends CreateMajorCMD {

    @NotNull
    @ApiModelProperty(value = "id", required = true)
    private Long id;

}
