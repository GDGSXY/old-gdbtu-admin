package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.AuthUtil;
import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.AcademyVO;
import cn.edu.gdbtu.admin.domain.user.assembler.AcademyAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.user.AcademyService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@RestController
@RequiredArgsConstructor
@Api("学院信息 Controller")
@RequestMapping("/v1/academy")
@RequiredPermission(PermissionEnum.ACADEMY_MANAGEMENT)
public class AcademyController {

    private final AcademyService service;

    private final AcademyAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索学院信息")
    public R<IPage<AcademyVO>> searchByCondition(@Valid SearchPagingQuery query) {
        IPage<Academy> page = service.searchByCondition(query);
        return R.success(page.convert(assembler::toVO));
    }

    @GetMapping("/by-login_user_permission")
    @ApiOperation("通过登录用户权限获取学院信息")
    public R<List<AcademyVO>> getByLoginUserPermission() {
        LoginUser user = AuthUtil.getUser();
        List<Academy> list = service.getByLoginUserPermission(user);
        return R.success(assembler.toListVO(list));
    }

}
