package cn.edu.gdbtu.admin.controller.user;

import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.user.cmd.CreateRoleCMD;
import cn.edu.gdbtu.admin.controller.user.cmd.UpdateRoleCMD;
import cn.edu.gdbtu.admin.controller.user.vo.RoleVO;
import cn.edu.gdbtu.admin.domain.user.assembler.RoleAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.application.RoleAppService;
import cn.edu.gdbtu.admin.service.user.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    private final RoleAppService roleAppService;

    private final RoleAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索角色信息")
    public R<IPage<RoleVO>> searchByCondition(@Valid SearchPagingQuery query) {
        IPage<Role> page = service.searchByCondition(query);
        return R.success(page.convert(assembler::toVO));
    }

    @PostMapping
    @ApiOperation("创建角色")
    public R<Void> create(@Valid @RequestBody CreateRoleCMD cmd) {
        roleAppService.createRole(cmd);
        return R.success();
    }

    @PutMapping
    @ApiOperation("修改角色信息")
    public R<Void> update(@Valid @RequestBody UpdateRoleCMD cmd) {
        roleAppService.updateRole(cmd);
        return R.success();
    }

    @DeleteMapping("/{roleId}")
    @ApiOperation("删除角色信息")
    public R<Void> remove(@PathVariable("roleId") long roleId) {
        roleAppService.removeRole(roleId);
        return R.success();
    }

}
