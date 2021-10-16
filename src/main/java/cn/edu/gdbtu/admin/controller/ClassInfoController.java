package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.AuthUtil;
import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.ClassInfoVO;
import cn.edu.gdbtu.admin.domain.user.assembler.ClassInfoAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import cn.edu.gdbtu.admin.service.user.ClassInfoService;
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
 * 班级信息 Controller
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@RestController
@RequiredArgsConstructor
@Api("班级信息 Controller")
@RequestMapping("/v1/class_info")
public class ClassInfoController {

    private final ClassInfoService service;

    private final ClassInfoAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件获取班级信息")
    public R<IPage<ClassInfoVO>> getListByCondition(@Valid SearchPagingQuery query,
                                                    @ApiParam(value = "专业 id", required = true) long majorId) {
        IPage<ClassInfo> page = service.searchByCondition(query, majorId);
        return R.success(page.convert(assembler::toVO));
    }

    @GetMapping("/by-login_user_permission")
    @ApiOperation("通过登录用户权限获取专业信息")
    public R<List<ClassInfoVO>> getByLoginUserPermission() {
        LoginUser user = AuthUtil.getUser();
        List<ClassInfo> list = service.getByLoginUserPermission(user);
        return R.success(assembler.toListVO(list));
    }

}
