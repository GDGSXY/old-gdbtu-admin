package cn.edu.gdbtu.admin.domain.user.repository.dao;

import cn.edu.gdbtu.admin.domain.user.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
