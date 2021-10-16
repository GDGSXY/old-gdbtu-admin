package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.controller.vo.MajorVO;
import cn.edu.gdbtu.admin.domain.user.entity.Major;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface MajorAssembler {

    List<MajorVO> toListVO(List<Major> entities);

}