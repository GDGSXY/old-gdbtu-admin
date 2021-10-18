package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.user.cmd.CreateAcademyCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateAcademyCMD;

public interface AcademyAppService {
    void createAcademy(CreateAcademyCMD cmd);

    void updateAcademy(UpdateAcademyCMD cmd);

    void removeAcademy(long academyId);
}
