package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.query.PagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.domain.assembler.ClassInfoAssembler;
import cn.edu.gdbtu.admin.domain.entity.ClassInfo;
import cn.edu.gdbtu.admin.domain.vo.ClassInfoVO;
import cn.edu.gdbtu.admin.service.ClassInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    @ApiOperation("分页查询")
    public R<IPage<ClassInfoVO>> getPage(@Valid PagingQuery pagingQuery) {
        IPage<ClassInfo> page = service.page(pagingQuery.toPage());
        return R.success(page.convert(assembler::toVO));
    }

}
