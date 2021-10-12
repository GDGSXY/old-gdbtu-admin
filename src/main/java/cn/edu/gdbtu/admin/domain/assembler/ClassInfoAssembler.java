package cn.edu.gdbtu.admin.domain.assembler;

import cn.edu.gdbtu.admin.domain.entity.ClassInfo;
import cn.edu.gdbtu.admin.domain.vo.ClassInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ClassInfoAssembler {

    ClassInfoVO toVO(ClassInfo entity);

}
