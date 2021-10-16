package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Student;
import cn.edu.gdbtu.admin.domain.user.repository.dao.StudentDao;
import cn.edu.gdbtu.admin.service.user.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

    @Override
    public IPage<Student> searchByConditions(SearchPagingQuery query, Long academyId, Long majorId, Long classId) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<Student>()
                .eq(academyId != null, Student::getAcademyId, academyId)
                .eq(majorId != null, Student::getMajorId, majorId)
                .eq(classId != null, Student::getClassId, classId)
                .likeRight(query.getSearch() != null, Student::getName, query.getSearch());
        return getBaseMapper().selectPage(query.toPage(), wrapper);
    }

}
