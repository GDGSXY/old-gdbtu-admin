package cn.edu.gdbtu.admin.domain.assembler;

import cn.edu.gdbtu.admin.domain.entity.User;
import cn.edu.gdbtu.admin.domain.vo.LoginUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jover Zhang
 * @date 2021/10/14
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface UserAssembler {

    LoginUserVO toLoginUserVO(User loginUser, String token);

}
