package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Student;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
public interface StudentService extends IService<Student> {

    IPage<Student> searchByConditions(SearchPagingQuery query, Long academyId, Long majorId, Long classId);

}
