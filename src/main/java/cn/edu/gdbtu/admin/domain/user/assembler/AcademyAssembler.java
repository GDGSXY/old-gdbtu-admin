package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntity;
import cn.edu.gdbtu.admin.common.entity.IgnoreToBaseEntityWithId;
import cn.edu.gdbtu.admin.controller.user.cmd.CreateAcademyCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateAcademyCMD;
import cn.edu.gdbtu.admin.controller.user.vo.AcademyVO;
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

    @IgnoreToBaseEntityWithId
    Academy toEntity(CreateAcademyCMD cmd);

    @IgnoreToBaseEntity
    Academy toEntity(UpdateAcademyCMD cmd);
}
