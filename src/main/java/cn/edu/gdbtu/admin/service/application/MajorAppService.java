package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.user.cmd.CreateMajorCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateMajorCMD;

public interface MajorAppService {
    void createMajor(CreateMajorCMD cmd);

    void updateMajor(UpdateMajorCMD cmd);

    void deleteMajor(long majorId);
}
