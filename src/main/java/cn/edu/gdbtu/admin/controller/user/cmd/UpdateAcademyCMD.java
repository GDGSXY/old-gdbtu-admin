package cn.edu.gdbtu.admin.controller.user.cmd;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateAcademyCMD extends CreateAcademyCMD {

    @NotNull
    @ApiModelProperty(value = "id", required = true)
    private Long id;

}

