package cn.edu.gdbtu.admin.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Data
@ApiModel("专业信息")
public class MajorVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("学院 id")
    private Long academyId;

    @ApiModelProperty("专业名称")
    private String name;

}
