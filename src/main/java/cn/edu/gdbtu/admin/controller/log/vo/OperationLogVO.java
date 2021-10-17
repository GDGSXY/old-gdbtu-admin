package cn.edu.gdbtu.admin.controller.log.vo;

import cn.edu.gdbtu.admin.domain.log.entity.OperationLogContent;
import cn.edu.gdbtu.admin.domain.log.enums.PositionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@Data
@ApiModel("操作日志信息")
public class OperationLogVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("操作日志的用户 id")
    private Long userId;

    @ApiModelProperty("日志产生的位置")
    private PositionEnum position;

    @ApiModelProperty("日志内容")
    private OperationLogContent content;

    @ApiModelProperty("日志产生时间")
    private LocalDateTime date;

}
