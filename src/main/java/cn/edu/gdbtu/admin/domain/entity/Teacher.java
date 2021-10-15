package cn.edu.gdbtu.admin.domain.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.enums.TeacherJobStatusEnum;
import cn.edu.gdbtu.admin.domain.enums.UserSexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 教师信息
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {

    /**
     * 用户 id
     *
     * @see User#getId()
     */
    private Long userId;

    /**
     * 工号
     */
    private String teacherCode;

    /**
     * 学院代码
     */
    private String academyCode;

    /**
     * 性别
     */
    private UserSexEnum gender;

    /**
     * 身份证号码
     */
    private String identificationNumber;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 联系电话
     */
    private String concatNumber;

    /**
     * 政治面貌
     */
    private PoliticalOutlookEnum politicalOutlook;

    /**
     * 本科毕业学校
     */
    private String undergraduateSchool;

    /**
     * 本科毕业专业
     */
    private String undergraduateMajor;

    /**
     * 硕士毕业学校
     */
    private String masterGraduateSchool;

    /**
     * 硕士毕业专业
     */
    private String masterGraduateMajor;

    /**
     * 入职状态
     */
    private TeacherJobStatusEnum jobStatus;

    /**
     * 删除时间
     */
    private String deleteTime;

}
