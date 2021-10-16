package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.controller.vo.AcademyVO;
import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface AcademyAssembler {

    AcademyVO toVO(Academy entity);

    List<AcademyVO> toListVO(List<Academy> entities);

}
