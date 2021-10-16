package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.UserVO;
import cn.edu.gdbtu.admin.domain.user.assembler.UserAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.user.UserService;
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
@Api("教职工信息 Controller")
@RequestMapping("/v1/user")
@RequiredPermission(PermissionEnum.TEACHER_MANAGEMENT)
public class UserController {

    private final UserService service;

    private final UserAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索用户信息")
    public R<IPage<UserVO>> searchByCondition(@Valid SearchPagingQuery query) {
        IPage<User> page = service.searchByCondition(query);
        return R.success(page.convert(assembler::toVO));
    }

}
