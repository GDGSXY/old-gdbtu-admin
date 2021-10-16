package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface RoleService extends IService<Role> {

    IPage<Role> searchByCondition(SearchPagingQuery query);

}
