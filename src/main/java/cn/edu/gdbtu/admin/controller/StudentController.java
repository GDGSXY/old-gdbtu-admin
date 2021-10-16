package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.RequiredPermission;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.cmd.CreateStudentCMD;
import cn.edu.gdbtu.admin.controller.vo.StudentVO;
import cn.edu.gdbtu.admin.domain.user.assembler.StudentAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Student;
import cn.edu.gdbtu.admin.domain.user.enums.PermissionEnum;
import cn.edu.gdbtu.admin.service.application.StudentAppService;
import cn.edu.gdbtu.admin.service.user.StudentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@RestController
@RequiredArgsConstructor
@Api("学生信息 Controller")
@RequestMapping("/v1/student")
@RequiredPermission(PermissionEnum.STUDENT_MANAGEMENT)
public class StudentController {

    private final StudentService service;

    private final StudentAppService studentAppService;

    private final StudentAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索学生信息")
    public R<IPage<StudentVO>> searchByCondition(@Valid SearchPagingQuery query, Long classId) {
        IPage<Student> page = service.searchByConditions(query, classId);
        return R.success(page.convert(assembler::toVO));
    }

    @PostMapping
    @ApiOperation("创建学生")
    public R<Void> create(@Valid @RequestBody CreateStudentCMD cmd) {
        studentAppService.createStudent(cmd);
        return R.success();
    }

}
