package cn.edu.gdbtu.admin.service.impl;

import cn.edu.gdbtu.admin.domain.entity.Student;
import cn.edu.gdbtu.admin.repository.dao.StudentDao;
import cn.edu.gdbtu.admin.service.StudentService;
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
