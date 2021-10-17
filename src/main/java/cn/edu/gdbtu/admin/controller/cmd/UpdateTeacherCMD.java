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

    @NotNull
    @ApiModelProperty(value = "身份证号")
    private String identificationNumber;

    @NotNull
    @ApiModelProperty(value = "民族")
    private String nativePlace;

    @NotNull
    @ApiModelProperty(value = "联系电话")
    private String concatNumber;

    @NotNull
    @ApiModelProperty(value = "政治面貌")
    private PoliticalOutlookEnum politicalOutlook;

    @NotNull
    @ApiModelProperty(value = "本科毕业学校")
    private String undergraduateSchool;

    @NotNull
    @ApiModelProperty(value = "本科毕业专业")
    private String undergraduateMajor;

    @NotNull
    @ApiModelProperty(value = "硕士毕业学校")
    private String masterGraduateSchool;

    @NotNull
    @ApiModelProperty(value = "硕士毕业专业")
    private String masterGraduateMajor;

    @NotNull
    @ApiModelProperty(value = "入职状态")
    private TeacherJobStatusEnum jobStatus;
}
