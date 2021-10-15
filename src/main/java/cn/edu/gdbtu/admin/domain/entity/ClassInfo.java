package cn.edu.gdbtu.admin.domain.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.enums.ClassGraduationStatusEnum;
import cn.edu.gdbtu.admin.domain.enums.ClassScheduleStatusEnum;
import cn.edu.gdbtu.admin.domain.enums.EducationLevelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 班级信息
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassInfo extends BaseEntity {

    /**
     * 班主任 id
     */
    private Long headTeacherId;

    /**
     * 班级代码
     */
    private String classCode;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 学院代码
     */
    private String academyCode;

    /**
     * 学院名称
     */
    private String academyName;

    /**
     * 开设年份
     */
    private String establishYear;

    /**
     * 学制
     */
    private String schoolYear;

    /**
     * 专业代码
     */
    private String majorCode;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 培养层次
     */
    private EducationLevelEnum educationLevel;

    /**
     * 校区代码
     */
    private String campusCode;

    /**
     * 校区名称
     */
    private String campusName;

    /**
     * 带班状态
     */
    private ClassScheduleStatusEnum scheduleStatus;

    /**
     * 毕业状态
     */
    private ClassGraduationStatusEnum status;

    /**
     * 班级人数
     */
    private Integer count;

}
