package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.user.cmd.CreateTeacherCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateTeacherCMD;

public interface TeacherAppService {
    void createTeacher(CreateTeacherCMD cmd);

    void updateTeacher(UpdateTeacherCMD cmd);

    void deleteTeacher(long teacherId);
}
