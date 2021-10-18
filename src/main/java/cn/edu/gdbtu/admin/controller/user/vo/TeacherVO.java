package cn.edu.gdbtu.admin.controller.user.vo;

import cn.edu.gdbtu.admin.domain.user.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.user.enums.TeacherJobStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.UserGenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Data
@ApiModel("教职工信息")
public class TeacherVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("用户 id")
    private Long userId;

    @ApiModelProperty("学院 id")
    private Long academyId;

    @ApiModelProperty("教师工号")
    private String teacherCode;

    @ApiModelProperty("教师姓名")
    private String name;

    @ApiModelProperty("性别")
    private UserGenderEnum gender;

    @ApiModelProperty("身份证号码")
    private String identificationNumber;

    @ApiModelProperty("籍贯")
    private String nativePlace;

    @ApiModelProperty("联系电话")
    private String concatNumber;

    @ApiModelProperty("政治面貌")
    private PoliticalOutlookEnum politicalOutlook;

    @ApiModelProperty("本科毕业学校")
    private String undergraduateSchool;

    @ApiModelProperty("本科毕业专业")
    private String undergraduateMajor;

    @ApiModelProperty("硕士毕业学校")
    private String masterGraduateSchool;

    @ApiModelProperty("硕士毕业专业")
    private String masterGraduateMajor;

    @ApiModelProperty("入职状态")
    private TeacherJobStatusEnum jobStatus;

}
