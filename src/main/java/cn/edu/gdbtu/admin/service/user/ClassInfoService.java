package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
public interface ClassInfoService extends IService<ClassInfo> {

    IPage<ClassInfo> searchByCondition(SearchPagingQuery query, Long majorId);

    List<ClassInfo> getByLoginUserPermission(LoginUser user, Long majorId);

    void create(ClassInfo classInfo);

}
