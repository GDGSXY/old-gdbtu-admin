package cn.edu.gdbtu.admin.controller.cmd;

import cn.edu.gdbtu.admin.domain.user.enums.EducationLevelEnum;
import cn.edu.gdbtu.admin.domain.user.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.user.enums.StudentStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.UserGenderEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Data
public class CreateStudentCMD {

    @NotNull
    @ApiModelProperty(value = "班级 id", required = true)
    private Long classId;

    @NotNull
    @ApiModelProperty(value = "学号", required = true)
    private String studentCode;

    @NotBlank
    @ApiModelProperty(value = "学生姓名", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "性别", required = true)
    private UserGenderEnum gender;

    @NotBlank
    @ApiModelProperty(value = "姓名拼音", required = true)
    private String pinyinName;

    @NotNull
    @ApiModelProperty(value = "学籍状态", required = true)
    private StudentStatusEnum studentStatus;

    @NotNull
    @ApiModelProperty(value = "政治面貌", required = true)
    private PoliticalOutlookEnum politicalOutlook;

    @NotBlank
    @ApiModelProperty(value = "身份证号", required = true)
    private String identificationNumber;

    @NotNull
    @ApiModelProperty(value = "宿舍号", required = true)
    private String dormitoryNumber;

    @NotNull
    @ApiModelProperty(value = "学生类别", required = true)
    private String studentType;

    @ApiModelProperty("准考证号")
    private String admissionTicketNumber;

    @ApiModelProperty("出生日期")
    private String birthDate;

    @ApiModelProperty("民族")
    private String nationality;

    @ApiModelProperty("学制")
    private String schoolYear;

    @ApiModelProperty("年级")
    private String grade;

    @ApiModelProperty("照片")
    private String image;

    @ApiModelProperty("入学日期")
    private String enrollmentDate;

    @ApiModelProperty("考生类别")
    private String candidateCategory;

    @ApiModelProperty("原毕业学校")
    private String graduatedSchool;

    @ApiModelProperty("入学方式")
    private String enrollmentWay;

    @ApiModelProperty("办学形式")
    private String schoolForm;

    @ApiModelProperty("培养层次")
    private EducationLevelEnum educationLevel;

    @ApiModelProperty("生源所在地")
    private String originPlace;

    @ApiModelProperty("籍贯")
    private String nativePlace;

    @ApiModelProperty("出生地")
    private String birthPlace;

    @ApiModelProperty("家庭地址")
    private String address;

    @ApiModelProperty("邮政编码")
    private String postCode;

    @ApiModelProperty("宅电")
    private String homePhone;

    @ApiModelProperty("个人电话")
    private String phoneNumber;

    @ApiModelProperty("健康状况")
    private String healthy;

    @ApiModelProperty("特长")
    private String hobby;

    @ApiModelProperty("学习年限")
    private String learningTime;

    @ApiModelProperty("入学总分")
    private String enrollmentScore;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("校区")
    private String campus;

    @ApiModelProperty("e_mail")
    private String email;

    @ApiModelProperty("目的火车站")
    private String station;

    @ApiModelProperty("考生号")
    private String candidateNumber;

    @ApiModelProperty("QQ号码")
    private String qq;

    @ApiModelProperty("入学年份")
    private String enrollmentYear;

    @ApiModelProperty("学科大类")
    private String subjectType;

    @ApiModelProperty("学科")
    private String subject;

    @ApiModelProperty("国际专业代码")
    private String nationMajorCode;

    @ApiModelProperty("专业培养层次")
    private String majorTrainingLevel;

    @ApiModelProperty("其他办学形式")
    private String otherSchoolForm;

    @ApiModelProperty("生源身份")
    private String originIdentity;

    @ApiModelProperty("毕业类别")
    private String graduateType;

    @ApiModelProperty("联系人")
    private String concatName;

    @ApiModelProperty("入党团日期")
    private String joinDate;

    @ApiModelProperty("招生季节")
    private String admissionSeason;

    @ApiModelProperty("入学文化程度")
    private String enrollmentEducationLevel;

    @ApiModelProperty("主修外语语种")
    private String foreignLanguage;

    @ApiModelProperty("学习形式")
    private String learningWay;

    @ApiModelProperty("办学类型")
    private String schoolFormType;

    @ApiModelProperty("培养对象")
    private String nourishObject;

    @ApiModelProperty("录取专业")
    private String admissionMajor;

    @ApiModelProperty("学校代码")
    private String schoolCode;

    @ApiModelProperty("是否报到")
    private String checkIn;

    @ApiModelProperty("联系电话")
    private String concatPhone;

}
