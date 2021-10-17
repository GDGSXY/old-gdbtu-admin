package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Teacher;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> searchByConditions(SearchPagingQuery query, Long academyId);

    /**
     * 通过 学院 id 获取所有 辅导员信息
     */
    List<Teacher> getAllCounselorByAcademyId(long academyId);

    /**
     * 通过 学院 id 获取所有 班主任信息
     */
    List<Teacher> getAllHeadTeacherByAcademyId(long academyId);

    void createTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

}
