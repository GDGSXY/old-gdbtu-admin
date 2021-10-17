package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import cn.edu.gdbtu.admin.domain.user.repository.dao.AcademyDao;
import cn.edu.gdbtu.admin.service.user.AcademyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
public class AcademyServiceImpl extends ServiceImpl<AcademyDao, Academy> implements AcademyService {

    @Override
    public IPage<Academy> searchByCondition(SearchPagingQuery query) {
        LambdaQueryWrapper<Academy> wrapper = new LambdaQueryWrapper<Academy>()
                .likeRight(query.getSearch() != null, Academy::getName, query.getSearch());
        return page(query.toPage(), wrapper);
    }

    @Override
    public List<Academy> getByLoginUserPermission(LoginUser user) {
        return list();
    }

    @Override
    public void updateAcademy(Academy newAcademy) {
        Assert.isTrue(updateById(newAcademy), "更新失败");
    }

}
