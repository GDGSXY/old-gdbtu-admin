package cn.edu.gdbtu.admin.controller.vo;

import cn.edu.gdbtu.admin.domain.user.enums.ClassGraduationStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.ClassScheduleStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.EducationLevelEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@ApiModel("班级信息")
public class ClassInfoVO {

    @ApiModelProperty("班级名称")
    private String name;

    @ApiModelProperty("专业 id")
    private Long majorId;

    @ApiModelProperty("辅导员 id")
    private Long counselorId;

    @ApiModelProperty("班主任 id")
    private Long headTeacherId;


    // 详细信息

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
