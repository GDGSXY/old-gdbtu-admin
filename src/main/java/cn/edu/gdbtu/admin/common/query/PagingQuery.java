package cn.edu.gdbtu.admin.common.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 分页查询
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
public class PagingQuery {

    @Min(1)
    @NotNull
    private Long current;

    @Min(1)
    @Max(100)
    @NotNull
    private Long pageSize;

    public <T> IPage<T> toPage() {
        return new Page<>(current, pageSize);
    }

}
