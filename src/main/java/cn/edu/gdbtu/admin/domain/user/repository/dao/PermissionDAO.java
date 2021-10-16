package cn.edu.gdbtu.admin.domain.user.repository.dao;

import cn.edu.gdbtu.admin.domain.user.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Mapper
public interface PermissionDAO extends BaseMapper<Permission> {
}
