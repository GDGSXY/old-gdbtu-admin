package cn.edu.gdbtu.admin.domain.user.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.user.enums.ClassGraduationStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.ClassScheduleStatusEnum;
import cn.edu.gdbtu.admin.domain.user.enums.EducationLevelEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 班级
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassInfo extends BaseEntity {

    private String name;

    private Long majorId;

    private Long counselorId;

    private Long headTeacherId;


    // 详细信息

    /**
     * 开设年份
     */
    private String establishYear;

    /**
     * 学制
     */
    private String schoolYear;

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
