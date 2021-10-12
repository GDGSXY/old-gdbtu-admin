package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.domain.assembler.StudentAssembler;
import cn.edu.gdbtu.admin.domain.entity.Student;
import cn.edu.gdbtu.admin.domain.vo.StudentVO;
import cn.edu.gdbtu.admin.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@RestController
@RequiredArgsConstructor
@Api("学生信息 Controller")
@RequestMapping("/v1/student")
public class StudentController {

    private final StudentService service;

    private final StudentAssembler assembler;

    @GetMapping("/{classId}")
    @ApiOperation("通过 班级 id 查询 班级内所有学生")
    public R<List<StudentVO>> getByClassId(@PathVariable("classId") @NotNull String classId) {
        List<Student> list = service.getByClassId(classId);
        return R.success(assembler.toVO(list));
    }

}
