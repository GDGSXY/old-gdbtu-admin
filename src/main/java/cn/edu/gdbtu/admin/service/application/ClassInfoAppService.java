package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.user.cmd.CreateClassInfoCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateClassInfoCMD;

public interface ClassInfoAppService {

    void createClassInfo(CreateClassInfoCMD cmd);

    void updateClassInfo(UpdateClassInfoCMD cmd);

    void removeClassInfo(long classId);

}
