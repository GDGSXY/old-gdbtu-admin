package cn.edu.gdbtu.admin.domain.log.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 操作日志
 *
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OperationLog extends BaseEntity {

    private Long userId;

    private String position;

    private String content;

}
