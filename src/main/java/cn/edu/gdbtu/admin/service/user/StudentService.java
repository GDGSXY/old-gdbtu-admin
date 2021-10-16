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

    /**
     * 通过条件搜索 Student
     *
     * @param query   搜索条件
     * @param classId 班级 id
     * @return Page of Student
     */
    IPage<Student> searchByConditions(SearchPagingQuery query, Long classId);

    /**
     * 创建 Student
     *
     * @param student 学生信息
     */
    void create(Student student);

}
