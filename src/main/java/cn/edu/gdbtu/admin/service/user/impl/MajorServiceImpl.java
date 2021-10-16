package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Major;
import cn.edu.gdbtu.admin.domain.user.repository.dao.MajorDao;
import cn.edu.gdbtu.admin.service.user.MajorService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorDao, Major> implements MajorService {

    @Override
    public IPage<Major> searchByCondition(SearchPagingQuery query, long academyId) {
        LambdaQueryWrapper<Major> wrapper = new LambdaQueryWrapper<Major>()
                .likeRight(query.getSearch() != null, Major::getName, query.getSearch());
        return page(query.toPage(), wrapper);
    }

    @Override
    public List<Major> getByLoginUserPermission(LoginUser user) {
        return list();
    }

}
