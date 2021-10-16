package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Major;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface MajorService extends IService<Major> {

    IPage<Major> searchByCondition(SearchPagingQuery query, Long academyId);

    List<Major> getByLoginUserPermission(LoginUser user, long academyId);

}
