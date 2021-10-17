package cn.edu.gdbtu.admin.service.log;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.common.query.PagingQuery;
import cn.edu.gdbtu.admin.domain.log.entity.OperationLog;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
public interface OperationLogService {

    IPage<OperationLog> getPageByPosition(PagingQuery query, PositionEnum position);

    void logCreate(PositionEnum position, long id);

    void logUpdate(PositionEnum position, BaseEntity before, BaseEntity after);

    void logRemove(PositionEnum position, long id);

}
