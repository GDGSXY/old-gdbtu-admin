package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.controller.cmd.CreateStudentCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateStudentCMD;
import cn.edu.gdbtu.admin.domain.user.assembler.StudentAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Student;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.service.application.StudentAppService;
import cn.edu.gdbtu.admin.service.user.StudentService;
import cn.edu.gdbtu.admin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
@RequiredArgsConstructor
public class StudentAppServiceImpl implements StudentAppService {

    private final UserService userService;

    private final StudentService studentService;

    private final StudentAssembler studentAssembler;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createStudent(CreateStudentCMD cmd) {
        // 创建 User
        User user = userService.create(cmd.getPinyinName());
        // 创建 Student
        Student student = studentAssembler.toEntity(cmd, user.getId());
        studentService.create(student);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStudent(UpdateStudentCMD cmd) {
        Student oldStudent = studentService.getById(cmd.getId());
        Student newStudent = studentAssembler.toEntity(cmd, oldStudent.getUserId());
        studentService.updateStudent(newStudent);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStudent(long studentId) {
        Student student = studentService.getById(studentId);
        studentService.removeById(studentId);
        userService.removeById(student.getUserId());
    }

}
