package cn.edu.gdbtu.admin.common.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jover Zhang
 * @date 2021/10/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SearchPagingQuery extends PagingQuery {

    private String search;

}
