package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.controller.cmd.CreateMajorCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateMajorCMD;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.user.assembler.MajorAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Major;
import cn.edu.gdbtu.admin.service.application.MajorAppService;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import cn.edu.gdbtu.admin.service.user.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MajorAppServiceImpl implements MajorAppService {

    private final MajorService majorService;

    private final OperationLogService operationLogService;

    private final MajorAssembler majorAssembler;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMajor(CreateMajorCMD cmd) {
        Major major = majorAssembler.toEntity(cmd);
        majorService.create(major);

        operationLogService.logCreate(PositionEnum.MAJOR_MANAGEMENT, major.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMajor(UpdateMajorCMD cmd) {
        Major oldMajor = majorService.getById(cmd.getId());
        Major newMajor = majorAssembler.toEntity(cmd);
        majorService.updateMajor(newMajor);
        newMajor = majorService.getById(cmd.getId());

        operationLogService.logUpdate(PositionEnum.MAJOR_MANAGEMENT, oldMajor, newMajor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteMajor(long majorId) {
        majorService.removeById(majorId);

        operationLogService.logRemove(PositionEnum.MAJOR_MANAGEMENT, majorId);
    }
}
