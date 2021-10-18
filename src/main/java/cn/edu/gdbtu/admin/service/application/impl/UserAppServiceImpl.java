package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.user.assembler.UserAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.service.application.UserAppService;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import cn.edu.gdbtu.admin.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jover Zhang
 * @date 2021/10/19
 */
@Service
@RequiredArgsConstructor
public class UserAppServiceImpl implements UserAppService {

    private final UserService userService;

    private final OperationLogService operationLogService;

    private final UserAssembler userAssembler;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserRole(long userId, long roleId) {
        User oldUser = userService.getById(userId);
        User newUser = userAssembler.cloneUser(oldUser).setRoleId(roleId);
        userService.updateUser(newUser);
        newUser = userService.getById(userId);
        // Log
        operationLogService.logUpdate(PositionEnum.USER_MANAGEMENT, oldUser, newUser);
    }

}
