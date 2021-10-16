package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.MajorVO;
import cn.edu.gdbtu.admin.domain.user.assembler.MajorAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Major;
import cn.edu.gdbtu.admin.service.user.MajorService;
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
@Api("专业信息 Controller")
@RequestMapping("/v1/major")
public class MajorController {

    private final MajorService service;

    private final MajorAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件获取专业信息")
    public R<List<MajorVO>> getListByCondition(long academyId) {
        List<Major> list = service.getListByCondition(academyId);
        return R.success(assembler.toListVO(list));
    }

}
