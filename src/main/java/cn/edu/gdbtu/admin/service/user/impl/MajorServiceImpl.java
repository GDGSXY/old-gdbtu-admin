package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import cn.edu.gdbtu.admin.domain.user.entity.Major;
import cn.edu.gdbtu.admin.domain.user.repository.dao.MajorDao;
import cn.edu.gdbtu.admin.service.user.AcademyService;
import cn.edu.gdbtu.admin.service.user.MajorService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
@RequiredArgsConstructor
public class MajorServiceImpl extends ServiceImpl<MajorDao, Major> implements MajorService {

    private final AcademyService academyService;

    @Override
    public IPage<Major> searchByCondition(SearchPagingQuery query, Long academyId) {
        LambdaQueryWrapper<Major> wrapper = new LambdaQueryWrapper<Major>()
                .eq(academyId != null, Major::getAcademyId, academyId)
                .likeRight(query.getSearch() != null, Major::getName, query.getSearch());
        return page(query.toPage(), wrapper);
    }

    @Override
    public List<Major> getByLoginUserPermission(LoginUser user, long academyId) {
        LambdaQueryWrapper<Major> wrapper = new LambdaQueryWrapper<Major>()
                .eq(Major::getAcademyId, academyId);
        return list(wrapper);
    }

    @Override
    public void create(Major major) {
        Academy academy = academyService.getById(major.getAcademyId());
        Assert.notNull(academy, "学院不存在");

        getBaseMapper().insert(major);
    }

    @Override
    public void updateMajor(Major major) {
        Academy academy = academyService.getById(major.getAcademyId());
        Assert.notNull(academy, "学院不存在");

        Assert.isTrue(updateById(major), "更新失败");
    }

}
