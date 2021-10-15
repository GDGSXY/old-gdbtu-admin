package cn.edu.gdbtu.admin.domain.user;

import lombok.Getter;

/**
 * 角色职级
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
public enum RoleLevelEnum {
    /**
     * Admin
     */
    ADMIN(1),
    /**
     * 院长
     */
    DEAN(2),
    /**
     * 二级院长
     */
    SECOND_DEAN(3),
    /**
     * 辅导员
     */
    COUNSELOR(4),
    /**
     * 班主任
     */
    HEAD_TEACHER(4),
    /**
     * 教职工
     */
    TEACHER(4),
    /**
     * 学生
     */
    STUDENT(5);

    /**
     * 等级
     */
    private final @Getter int level;

    RoleLevelEnum(int level) {
        this.level = level;
    }
}
