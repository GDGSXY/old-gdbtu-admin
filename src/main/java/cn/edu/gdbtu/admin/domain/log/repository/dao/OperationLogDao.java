package cn.edu.gdbtu.admin.domain.log.repository.dao;

import cn.edu.gdbtu.admin.domain.log.entity.OperationLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@Mapper
public interface OperationLogDao extends BaseMapper<OperationLog> {
}
