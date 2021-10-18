package cn.edu.gdbtu.admin.service.application;

import cn.edu.gdbtu.admin.controller.user.cmd.CreateRoleCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateRoleCMD;

/**
 * @author Jover Zhang
 * @date 2021/10/18
 */
public interface RoleAppService {

    void createRole(CreateRoleCMD cmd);

    void updateRole(UpdateRoleCMD cmd);

    void removeRole(long roleId);

}
