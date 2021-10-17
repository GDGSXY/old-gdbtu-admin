package cn.edu.gdbtu.admin.controller.log;

import cn.edu.gdbtu.admin.common.query.PagingQuery;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.log.vo.OperationLogVO;
import cn.edu.gdbtu.admin.domain.log.assembler.OperationLogAssembler;
import cn.edu.gdbtu.admin.domain.log.entity.OperationLog;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import cn.edu.gdbtu.admin.service.log.OperationLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@RestController
@RequiredArgsConstructor
@Api("操作日志 Controller")
@RequestMapping("/v1/log/operation_log")
public class OperationLogController {

    private final OperationLogService service;

    private final OperationLogAssembler assembler;

    @GetMapping
    @ApiOperation("通过 Position 查询日志信息")
    public R<IPage<OperationLogVO>> getPageByPosition(@Valid PagingQuery query,
                                                      @ApiParam("产生日志的位置") @NotNull PositionEnum position) {
        IPage<OperationLog> page = service.getPageByPosition(query, position);
        return R.success(page.convert(assembler::toVO));
    }

}
