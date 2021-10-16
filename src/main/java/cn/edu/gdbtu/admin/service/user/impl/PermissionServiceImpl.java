package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.domain.user.entity.Permission;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.domain.user.repository.dao.PermissionDAO;
import cn.edu.gdbtu.admin.service.user.PermissionService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDAO, Permission> implements PermissionService {

    @Override
    public List<PermissionEnum> getPermissionsByRoleId(long roleId) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<Permission>()
                .eq(Permission::getRoleId, roleId);
        return list(wrapper).stream()
                .map(Permission::getResource)
                .toList();
    }

}
