package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.cmd.CreateTeacherCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateTeacherCMD;

public interface TeacherAppService {
    void createTeacher(CreateTeacherCMD cmd);

    void updateTeacher(UpdateTeacherCMD cmd);

    void deleteTeacher(long teacherId);
}
