package cn.edu.gdbtu.admin.controller.cmd;

import cn.edu.gdbtu.admin.domain.user.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.user.enums.TeacherJobStatusEnum;
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


    @ApiModelProperty(value = "身份证号")
    private String identificationNumber;

    @ApiModelProperty(value = "民族")
    private String nativePlace;

    @NotNull
    @ApiModelProperty(value = "联系电话")
    private String concatNumber;

    @ApiModelProperty(value = "本科毕业学校")
    private String undergraduateSchool;

    @ApiModelProperty(value = "本科毕业专业")
    private String undergraduateMajor;

    @ApiModelProperty(value = "硕士毕业学校")
    private String masterGraduateSchool;

    @ApiModelProperty(value = "硕士毕业专业")
    private String masterGraduateMajor;

    @ApiModelProperty(value = "入职状态")
    private TeacherJobStatusEnum jobStatus;
}
