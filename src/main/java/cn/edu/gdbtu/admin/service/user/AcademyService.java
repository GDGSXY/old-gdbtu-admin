package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
public interface AcademyService extends IService<Academy> {

    IPage<Academy> searchByCondition(SearchPagingQuery query);

    List<Academy> getByLoginUserPermission(LoginUser user);

    void updateAcademy(Academy newAcademy);

}
