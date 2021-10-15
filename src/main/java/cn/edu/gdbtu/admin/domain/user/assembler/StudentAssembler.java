package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.domain.user.entity.Student;
import cn.edu.gdbtu.admin.controller.vo.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface StudentAssembler {

    List<StudentVO> toVO(List<Student> entities);

    StudentVO toVO(Student entity);

}
