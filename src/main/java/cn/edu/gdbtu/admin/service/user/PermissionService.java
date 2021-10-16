package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.domain.user.entity.Permission;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface PermissionService extends IService<Permission> {

    List<PermissionEnum> getPermissionsByRoleId(long roldId);

}
