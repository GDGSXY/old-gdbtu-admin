package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.controller.user.cmd.CreateRoleCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateRoleCMD;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.user.assembler.RoleAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.service.application.RoleAppService;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import cn.edu.gdbtu.admin.service.user.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jover Zhang
 * @date 2021/10/18
 */
@Service
@RequiredArgsConstructor
public class RoleAppServiceImpl implements RoleAppService {

    private final RoleService roleService;

    private final OperationLogService operationLogService;

    private final RoleAssembler roleAssembler;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createRole(CreateRoleCMD cmd) {
        Role role = roleAssembler.toEntity(cmd);
        roleService.create(role);
        // Log
        operationLogService.logCreate(PositionEnum.ROLE_MANAGEMENT, role.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRole(UpdateRoleCMD cmd) {
        Role oldRole = roleService.getById(cmd.getId());
        Role newRole = roleAssembler.toEntity(cmd);
        roleService.updateRole(newRole);
        newRole = roleService.getById(cmd.getId());
        // Log
        operationLogService.logUpdate(PositionEnum.ROLE_MANAGEMENT, oldRole, newRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeRole(long roleId) {
        roleService.removeRoleById(roleId);
        // Log
        operationLogService.logRemove(PositionEnum.ROLE_MANAGEMENT, roleId);
    }

}
