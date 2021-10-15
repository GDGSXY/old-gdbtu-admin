package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.domain.user.entity.Student;
import cn.edu.gdbtu.admin.domain.user.repository.dao.StudentDao;
import cn.edu.gdbtu.admin.service.user.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

    private final StudentDao dao;

    @Override
    public List<Student> getByClassId(String classId) {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<Student>()
                .eq(Student::getClassId, classId);
        return list(wrapper);
    }

}
