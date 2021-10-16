package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntity;
import cn.edu.gdbtu.admin.controller.cmd.CreateStudentCMD;
import cn.edu.gdbtu.admin.controller.vo.StudentVO;
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

    @IgnoreToBaseEntity
    Student toEntity(CreateStudentCMD cmd, long userId);

}
