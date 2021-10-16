package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.RoleVO;
import cn.edu.gdbtu.admin.domain.user.assembler.RoleAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.user.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@RestController
@RequiredArgsConstructor
@Api("角色信息 Controller")
@RequestMapping("/v1/role")
@RequiredPermission(PermissionEnum.ROLE_MANAGEMENT)
public class RoleController {

    private final RoleService service;

    private final RoleAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索角色信息")
    public R<IPage<RoleVO>> searchByCondition(@Valid SearchPagingQuery query) {
        IPage<Role> page = service.searchByCondition(query);
        return R.success(page.convert(assembler::toVO));
    }

}
