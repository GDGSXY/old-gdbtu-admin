package cn.edu.gdbtu.admin.domain.user.assembler;

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

}
