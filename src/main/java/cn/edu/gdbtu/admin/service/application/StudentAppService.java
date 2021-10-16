package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.cmd.CreateStudentCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateStudentCMD;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface StudentAppService {

    void createStudent(CreateStudentCMD cmd);

    void updateStudent(UpdateStudentCMD cmd);

    void deleteStudent(long studentId);

}
