package cn.edu.gdbtu.admin.service.log.impl;

import cn.edu.gdbtu.admin.common.auth.AuthUtil;
import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.common.query.PagingQuery;
import cn.edu.gdbtu.admin.domain.log.entity.OperationLog;
import cn.edu.gdbtu.admin.domain.log.entity.OperationLogContent;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.log.repository.dao.OperationLogDao;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@Service
@RequiredArgsConstructor
public class OperationLogServiceImpl implements OperationLogService {

    private final OperationLogDao dao;

    private final ObjectMapper objectMapper;

    @Override
    public IPage<OperationLog> getPageByPosition(PagingQuery query, PositionEnum position) {
        LambdaQueryWrapper<OperationLog> wrapper = new LambdaQueryWrapper<OperationLog>()
                .eq(OperationLog::getPosition, position)
                .orderByDesc(BaseEntity::getGmtCreate);
        return dao.selectPage(query.toPage(), wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void logCreate(PositionEnum position, long id) {
        OperationLogContent content = OperationLogContent.createForCreate(id);
        OperationLog log = new OperationLog()
                .setUserId(getUserId())
                .setPosition(position)
                .setContent(convert(content));
        dao.insert(log);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void logUpdate(PositionEnum position, BaseEntity before, BaseEntity after) {
        OperationLogContent content = OperationLogContent.createForUpdate(before, after);
        OperationLog log = new OperationLog()
                .setUserId(getUserId())
                .setPosition(position)
                .setContent(convert(content));
        dao.insert(log);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void logRemove(PositionEnum position, long id) {
        OperationLogContent content = OperationLogContent.createForRemove(id);
        OperationLog log = new OperationLog()
                .setUserId(getUserId())
                .setPosition(position)
                .setContent(convert(content));
        dao.insert(log);
    }

    @SneakyThrows
    private String convert(Object obj) {
        return objectMapper.writeValueAsString(obj);
    }

    private long getUserId() {
        return AuthUtil.getUser().getId();
    }

}
