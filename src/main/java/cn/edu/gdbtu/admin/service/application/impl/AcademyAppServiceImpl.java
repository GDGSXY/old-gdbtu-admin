package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.controller.user.cmd.CreateAcademyCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateAcademyCMD;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.user.assembler.AcademyAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import cn.edu.gdbtu.admin.service.application.AcademyAppService;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import cn.edu.gdbtu.admin.service.user.AcademyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AcademyAppServiceImpl implements AcademyAppService {

    private final AcademyService academyService;

    private final AcademyAssembler academyAssembler;

    private final OperationLogService operationLogService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAcademy(CreateAcademyCMD cmd) {
        Academy academy = academyAssembler.toEntity(cmd);

        academyService.save(academy);

        operationLogService.logCreate(PositionEnum.ACADEMY_MANAGEMENT, academy.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAcademy(UpdateAcademyCMD cmd) {
        Academy oldAcademy = academyService.getById(cmd.getId());
        Academy newAcademy = academyAssembler.toEntity(cmd);
        academyService.updateAcademy(newAcademy);
        newAcademy = academyService.getById(cmd.getId());

        operationLogService.logUpdate(PositionEnum.ACADEMY_MANAGEMENT, oldAcademy, newAcademy);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeAcademy(long academyId) {
        academyService.removeById(academyId);

        operationLogService.logRemove(PositionEnum.ACADEMY_MANAGEMENT, academyId);
    }
}
