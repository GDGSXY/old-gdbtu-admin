package cn.edu.gdbtu.admin.controller.cmd;

import cn.edu.gdbtu.admin.domain.user.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.user.enums.UserGenderEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateTeacherCMD {

    @NotNull
    @ApiModelProperty(value = "学院 id", required = true)
    private Long academyId;

    @NotNull
    @ApiModelProperty(value = "教师工号", required = true)
    private String teacherCode;

    @NotNull
    @ApiModelProperty(value = "教师姓名", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "性别", required = true)
    private UserGenderEnum gender;

    @NotNull
    @ApiModelProperty(value = "政治面貌", required = true)
    private PoliticalOutlookEnum politicalOutlook;

}
