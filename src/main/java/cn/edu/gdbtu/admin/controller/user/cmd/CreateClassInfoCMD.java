package cn.edu.gdbtu.admin.controller.user.cmd;

import cn.edu.gdbtu.admin.domain.user.enums.ClassGraduationStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.ClassScheduleStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.EducationLevelEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Jover Zhang
 * @date 2021/10/18
 */
@Data
public class CreateClassInfoCMD {

    @NotNull
    @ApiModelProperty(value = "班级名称", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "专业 id", required = true)
    private Long majorId;

    @NotNull
    @ApiModelProperty(value = "辅导员 id", required = true)
    private Long counselorId;

    @NotNull
    @ApiModelProperty(value = "班主任 id", required = true)
    private Long headTeacherId;

    @ApiModelProperty("开设年份")
    private String establishYear;

    @ApiModelProperty("学制")
    private String schoolYear;

    @ApiModelProperty("培养层次")
    private EducationLevelEnum educationLevel;

    @ApiModelProperty("校区代码")
    private String campusCode;

    @ApiModelProperty("校区名称")
    private String campusName;

    @ApiModelProperty("带班状态")
    private ClassScheduleStatusEnum scheduleStatus;

    @ApiModelProperty("毕业状态")
    private ClassGraduationStatusEnum status;

    @ApiModelProperty("班级人数")
    private Integer count;

}
