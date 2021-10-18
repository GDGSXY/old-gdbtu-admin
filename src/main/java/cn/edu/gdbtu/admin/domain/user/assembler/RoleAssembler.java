package cn.edu.gdbtu.admin.domain.user.assembler;

import cn.edu.gdbtu.admin.controller.user.vo.RoleVO;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface RoleAssembler {

    RoleVO toVO(Role entity);

}
