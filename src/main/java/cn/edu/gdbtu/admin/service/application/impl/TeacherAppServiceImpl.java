package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.controller.cmd.CreateTeacherCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateTeacherCMD;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.user.assembler.TeacherAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Teacher;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.service.application.TeacherAppService;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import cn.edu.gdbtu.admin.service.user.TeacherService;
import cn.edu.gdbtu.admin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeacherAppServiceImpl implements TeacherAppService {

    private final UserService userService;

    private final TeacherAssembler teacherAssembler;

    private final OperationLogService operationLogService;

    private final TeacherService teacherService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createTeacher(CreateTeacherCMD cmd) {
        User user = userService.createTeacher(cmd.getName());

        Teacher teacher = teacherAssembler.toEntity(cmd, user.getId());
        teacherService.createTeacher(teacher);

        operationLogService.logCreate(PositionEnum.TEACHER_MANAGEMENT, teacher.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTeacher(UpdateTeacherCMD cmd) {
        Teacher oldTeacher = teacherService.getById(cmd.getId());
        Teacher newTeacher = teacherAssembler.toEntity(cmd, oldTeacher.getUserId());
        teacherService.updateTeacher(newTeacher);
        newTeacher = teacherService.getById(cmd.getId());

        operationLogService.logUpdate(PositionEnum.TEACHER_MANAGEMENT, oldTeacher, newTeacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTeacher(long teacherId) {
        Teacher teacher = teacherService.getById(teacherId);
        teacherService.removeById(teacherId);
        userService.removeById(teacher.getUserId());

        operationLogService.logRemove(PositionEnum.TEACHER_MANAGEMENT, teacherId);
    }
}
