package cn.edu.gdbtu.admin.service.application.impl;

import cn.edu.gdbtu.admin.controller.cmd.CreateClassInfoCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateClassInfoCMD;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.domain.user.assembler.ClassInfoAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import cn.edu.gdbtu.admin.service.application.ClassInfoAppService;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import cn.edu.gdbtu.admin.service.user.ClassInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateClassInfo(UpdateClassInfoCMD cmd) {
        ClassInfo oldClassInfo = classInfoService.getById(cmd.getId());
        ClassInfo newClassInfo = classInfoAssembler.toEntity(cmd);
        classInfoService.updateClassInfo(newClassInfo);
        newClassInfo = classInfoService.getById(cmd.getId());
        // Log
        operationLogService.logUpdate(PositionEnum.CLASS_MANAGEMENT, oldClassInfo, newClassInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeClassInfo(long classId) {
        Assert.isTrue(classInfoService.removeById(classId), "删除失败");
        // Log
        operationLogService.logRemove(PositionEnum.CLASS_MANAGEMENT, classId);
    }

}
