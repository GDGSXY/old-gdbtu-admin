package cn.edu.gdbtu.admin.domain.log.assembler;

import cn.edu.gdbtu.admin.common.SpringUtil;
import cn.edu.gdbtu.admin.controller.log.vo.OperationLogVO;
import cn.edu.gdbtu.admin.domain.log.entity.OperationLog;
import cn.edu.gdbtu.admin.domain.log.entity.OperationLogContent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface OperationLogAssembler {

    @Mapping(source = "gmtCreate", target = "date")
    OperationLogVO toVO(OperationLog operationLog);

    @SneakyThrows
    default OperationLogContent convertOperationLogContent(String content) {
        return SpringUtil.getBean(ObjectMapper.class).readValue(content, OperationLogContent.class);
    }

}
