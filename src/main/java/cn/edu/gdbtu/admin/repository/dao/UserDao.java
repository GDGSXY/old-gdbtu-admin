package cn.edu.gdbtu.admin.repository.dao;

import cn.edu.gdbtu.admin.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
