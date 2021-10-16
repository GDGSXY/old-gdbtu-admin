package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.AuthUtil;
import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.MajorVO;
import cn.edu.gdbtu.admin.domain.user.assembler.MajorAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Major;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.user.MajorService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api("专业信息 Controller")
@RequestMapping("/v1/major")
@RequiredPermission(PermissionEnum.MAJOR_MANAGEMENT)
public class MajorController {

    private final MajorService service;

    private final MajorAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索专业信息")
    public R<IPage<MajorVO>> searchByCondition(@Valid SearchPagingQuery query,
                                               @ApiParam("学院 id") Long academyId) {
        IPage<Major> page = service.searchByCondition(query, academyId);
        return R.success(page.convert(assembler::toVO));
    }

    @GetMapping("/by-login_user_permission")
    @ApiOperation("通过登录用户权限获取专业信息")
    public R<List<MajorVO>> getByLoginUserPermission(@ApiParam(value = "学院 id", required = true) long academyId) {
        LoginUser user = AuthUtil.getUser();
        List<Major> list = service.getByLoginUserPermission(user, academyId);
        return R.success(assembler.toListVO(list));
    }

}
