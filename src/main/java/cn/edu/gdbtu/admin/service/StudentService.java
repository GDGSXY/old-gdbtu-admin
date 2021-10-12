package cn.edu.gdbtu.admin.service;

import cn.edu.gdbtu.admin.domain.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
public interface StudentService extends IService<Student> {

    List<Student> getByClassId(String classId);

}
