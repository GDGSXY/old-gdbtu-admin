package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.controller.cmd.CreateClassInfoCMD;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.user.assembler.ClassInfoAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import cn.edu.gdbtu.admin.service.application.ClassInfoAppService;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import cn.edu.gdbtu.admin.service.user.ClassInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassInfoAppServiceImpl implements ClassInfoAppService {

    private final ClassInfoService classInfoService;

    private final OperationLogService operationLogService;

    private final ClassInfoAssembler classInfoAssembler;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createClassInfo(CreateClassInfoCMD cmd) {
        ClassInfo classInfo = classInfoAssembler.toEntity(cmd);
        classInfoService.create(classInfo);
        // Log
        operationLogService.logCreate(PositionEnum.CLASS_MANAGEMENT, classInfo.getId());
    }

}
