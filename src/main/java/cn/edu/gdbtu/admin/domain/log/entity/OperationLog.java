package cn.edu.gdbtu.admin.domain.log.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 操作日志
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class OperationLog extends BaseEntity {

    private Long userId;

    private PositionEnum position;

    private String content;

}
