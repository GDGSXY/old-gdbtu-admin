package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.ClassInfoVO;
import cn.edu.gdbtu.admin.domain.user.assembler.ClassInfoAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import cn.edu.gdbtu.admin.service.user.ClassInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public R<List<ClassInfoVO>> getListByCondition(long majorId) {
        List<ClassInfo> list = service.getListByCondition(majorId);
        return R.success(assembler.toListVO(list));
    }

}
