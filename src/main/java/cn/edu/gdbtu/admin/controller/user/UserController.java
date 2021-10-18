package cn.edu.gdbtu.admin.controller.user;

import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.user.vo.UserVO;
import cn.edu.gdbtu.admin.domain.user.assembler.UserAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.application.UserAppService;
import cn.edu.gdbtu.admin.service.user.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@RestController
@RequiredArgsConstructor
@Api("教职工信息 Controller")
@RequestMapping("/v1/user")
@RequiredPermission(PermissionEnum.TEACHER_MANAGEMENT)
public class UserController {

    private final UserAppService userAppService;

    private final UserService service;

    private final UserAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索用户信息")
    public R<IPage<UserVO>> searchByCondition(@Valid SearchPagingQuery query) {
        IPage<User> page = service.searchByCondition(query);
        return R.success(page.convert(assembler::toVO));
    }

    @PostMapping("/role/{userId}")
    @ApiOperation("修改用户的角色")
    public R<Void> updateUserRole(@PathVariable("userId") long userId,
                                  @ApiParam(value = "角色 id", required = true) @RequestParam long roleId) {
        userAppService.updateUserRole(userId, roleId);
        return R.success();
    }

}
