package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.TeacherVO;
import cn.edu.gdbtu.admin.domain.user.assembler.TeacherAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Teacher;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.user.TeacherService;
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
@Api("教职工信息 Controller")
@RequestMapping("/v1/teacher")
@RequiredPermission(PermissionEnum.TEACHER_MANAGEMENT)
public class TeacherController {

    private final TeacherService service;

    private final TeacherAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索教职工信息")
    public R<IPage<TeacherVO>> searchByCondition(@Valid SearchPagingQuery query, Long academyId) {
        IPage<Teacher> page = service.searchByConditions(query, academyId);
        return R.success(page.convert(assembler::toVO));
    }

    @GetMapping("/counselor")
    @ApiOperation("通过 学院 id 获取所有辅导员信息")
    public R<List<TeacherVO>> getAllCounselorByAcademyId(@ApiParam(value = "学院 id", required = true) long academyId) {
        List<Teacher> list = service.getAllCounselorByAcademyId(academyId);
        return R.success(assembler.toListVO(list));
    }

    @GetMapping("/head_teacher")
    @ApiOperation("通过 学院 id 获取所有班主任信息")
    public R<List<TeacherVO>> getAllHeadTeacherByAcademyId(@ApiParam(value = "学院 id", required = true) long academyId) {
        List<Teacher> list = service.getAllHeadTeacherByAcademyId(academyId);
        return R.success(assembler.toListVO(list));
    }

}
