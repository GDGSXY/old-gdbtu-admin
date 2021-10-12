package cn.edu.gdbtu.admin.domain.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 操作日志
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OperationLog extends BaseEntity {

    /**
     * 操作行为
     */
    private String operation;

}
