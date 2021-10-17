package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.cmd.CreateClassInfoCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateClassInfoCMD;

public interface ClassInfoAppService {

    void createClassInfo(CreateClassInfoCMD cmd);

    void updateClassInfo(UpdateClassInfoCMD cmd);

}
