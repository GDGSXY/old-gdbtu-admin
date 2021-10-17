package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntity;
import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntityWithId;
import cn.edu.gdbtu.admin.controller.cmd.CreateTeacherCMD;
import cn.edu.gdbtu.admin.controller.cmd.UpdateTeacherCMD;
import cn.edu.gdbtu.admin.controller.vo.TeacherVO;
import cn.edu.gdbtu.admin.domain.user.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface TeacherAssembler {

    TeacherVO toVO(Teacher entity);

    @IgnoreToBaseEntityWithId
    Teacher toEntity(CreateTeacherCMD cmd, Long userId);

    @IgnoreToBaseEntity
    Teacher toEntity(UpdateTeacherCMD cmd, Long userId);
}
