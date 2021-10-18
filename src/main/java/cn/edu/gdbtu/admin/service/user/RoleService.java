package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.enums.RoleLevelEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface RoleService extends IService<Role> {

    IPage<Role> searchByCondition(SearchPagingQuery query);

    List<Role> getAllByRoleLevel(RoleLevelEnum roleLevel);

    void create(Role role);

    void updateRole(Role role);

    void removeRoleById(long roleId);

}
