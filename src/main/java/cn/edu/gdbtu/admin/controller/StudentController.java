package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.vo.StudentVO;
import cn.edu.gdbtu.admin.domain.user.assembler.StudentAssembler;
import cn.edu.gdbtu.admin.domain.user.entity.Student;
import cn.edu.gdbtu.admin.service.user.StudentService;
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
 * @date 2021/10/12
 */
@RestController
@RequiredArgsConstructor
@Api("学生信息 Controller")
@RequestMapping("/v1/student")
public class StudentController {

    private final StudentService service;

    private final StudentAssembler assembler;

    @GetMapping
    @ApiOperation("通过条件搜索学生信息")
    public R<IPage<StudentVO>> searchByCondition(@Valid SearchPagingQuery query, Long classId) {
        IPage<Student> page = service.searchByConditions(query, classId);
        return R.success(page.convert(assembler::toVO));
    }

}
