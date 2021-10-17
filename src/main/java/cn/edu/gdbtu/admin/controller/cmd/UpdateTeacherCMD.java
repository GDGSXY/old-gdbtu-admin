package cn.edu.gdbtu.admin.controller.cmd;

import cn.edu.gdbtu.admin.domain.user.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.user.enums.TeacherJobStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class UpdateTeacherCMD extends CreateTeacherCMD {

    @NotNull
    @ApiModelProperty(value = "教师 id", required = true)
    private Long id;
}
