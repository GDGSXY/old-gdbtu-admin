package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntity;
import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntityWithId;
import cn.edu.gdbtu.admin.controller.user.cmd.CreateClassInfoCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateClassInfoCMD;
import cn.edu.gdbtu.admin.controller.user.vo.ClassInfoVO;
import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ClassInfoAssembler {

    ClassInfoVO toVO(ClassInfo entity);

    List<ClassInfoVO> toListVO(List<ClassInfo> entities);

    @IgnoreToBaseEntityWithId
    ClassInfo toEntity(CreateClassInfoCMD cmd);

    @IgnoreToBaseEntity
    ClassInfo toEntity(UpdateClassInfoCMD cmd);

}
