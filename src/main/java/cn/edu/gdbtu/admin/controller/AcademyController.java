package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.AcademyVO;
import cn.edu.gdbtu.admin.domain.user.assembler.AcademyAssembler;
import cn.edu.gdbtu.admin.service.user.AcademyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@RestController
@RequiredArgsConstructor
@Api("学院信息 Controller")
@RequestMapping("/v1/academy")
public class AcademyController {

    private final AcademyService service;

    private final AcademyAssembler assembler;

    @GetMapping
    @ApiOperation("获取所有学院信息")
    public R<List<AcademyVO>> getAll() {
        return R.success(assembler.toListVO(service.list()));
    }

}
