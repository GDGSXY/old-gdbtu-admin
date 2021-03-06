package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntity;
import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntityWithId;
import cn.edu.gdbtu.admin.controller.user.cmd.CreateStudentCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateStudentCMD;
import cn.edu.gdbtu.admin.controller.user.vo.StudentVO;
import cn.edu.gdbtu.admin.domain.user.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface StudentAssembler {

    StudentVO toVO(Student entity);

    @IgnoreToBaseEntityWithId
    Student toEntity(CreateStudentCMD cmd, long userId);

    @IgnoreToBaseEntity
    Student toEntity(UpdateStudentCMD cmd, long userId);

}
