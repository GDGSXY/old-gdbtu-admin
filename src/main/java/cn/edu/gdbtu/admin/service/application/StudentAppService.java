package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.cmd.CreateStudentCMD;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface StudentAppService {

    void createStudent(CreateStudentCMD cmd);

}
