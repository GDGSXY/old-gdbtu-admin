package cn.edu.gdbtu.admin.domain.user.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.user.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.user.enums.TeacherJobStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.UserGenderEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 教职工
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {

    private Long userId;

    private String teacherCode;

    private Long academyId;


    // 详细信息

    /**
     * 性别
     */
    private UserGenderEnum gender;

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

}
