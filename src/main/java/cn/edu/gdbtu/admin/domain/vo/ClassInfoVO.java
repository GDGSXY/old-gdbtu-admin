package cn.edu.gdbtu.admin.domain.vo;

import cn.edu.gdbtu.admin.domain.enums.ClassGraduationStatusEnum;
import cn.edu.gdbtu.admin.domain.enums.ClassScheduleStatusEnum;
import cn.edu.gdbtu.admin.domain.enums.EducationLevelEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@ApiModel("班级信息")
public class ClassInfoVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("班主任 id")
    private Long headTeacherId;

    @ApiModelProperty("班级代码")
    private String bjdm;

    @ApiModelProperty("班级名称")
    private String bjmc;

    @ApiModelProperty("学院代码")
    private String xydm;

    @ApiModelProperty("学院名称")
    private String xymc;

    @ApiModelProperty("开设年份")
    private String ksnf;

    @ApiModelProperty("学制")
    private String xz;

    @ApiModelProperty("专业代码")
    private String zydm;

    @ApiModelProperty("专业名称")
    private String zymc;

    @ApiModelProperty("培养层次")
    private EducationLevelEnum educationLevel;

    @ApiModelProperty("校区代码")
    private String xqdm;

    @ApiModelProperty("校区名称")
    private String xqmc;

    @ApiModelProperty("带班状态")
    private ClassScheduleStatusEnum scheduleStatus;

    @ApiModelProperty("毕业状态")
    private ClassGraduationStatusEnum status;

    @ApiModelProperty("班级人数")
    private Integer count;

}
