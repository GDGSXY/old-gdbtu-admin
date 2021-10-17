package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import cn.edu.gdbtu.admin.domain.user.repository.dao.ClassInfoDao;
import cn.edu.gdbtu.admin.service.user.ClassInfoService;
import cn.edu.gdbtu.admin.service.user.MajorService;
import cn.edu.gdbtu.admin.service.user.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Service
@RequiredArgsConstructor
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoDao, ClassInfo> implements ClassInfoService {

    private final MajorService majorService;

    private final UserService userService;

    @Override
    public IPage<ClassInfo> searchByCondition(SearchPagingQuery query, Long majorId) {
        LambdaQueryWrapper<ClassInfo> wrapper = new LambdaQueryWrapper<ClassInfo>()
                .eq(majorId != null, ClassInfo::getMajorId, majorId)
                .likeRight(query.getSearch() != null, ClassInfo::getName, query.getSearch());
        return page(query.toPage(), wrapper);
    }

    @Override
    public List<ClassInfo> getByLoginUserPermission(LoginUser user, Long majorId) {
        LambdaQueryWrapper<ClassInfo> wrapper = new LambdaQueryWrapper<ClassInfo>()
                .eq(ClassInfo::getMajorId, majorId);
        return list(wrapper);
    }

    @Override
    public void create(ClassInfo classInfo) {
        Assert.notNull(majorService.getById(classInfo.getMajorId()), "专业不存在");
        // TODO: 待校验用户是否为 辅导员/班主任
        Assert.notNull(userService.getById(classInfo.getCounselorId()), "辅导员不存在");
        Assert.notNull(userService.getById(classInfo.getHeadTeacherId()), "班主任不存在");
        save(classInfo);
    }

    @Override
    public void updateClassInfo(ClassInfo classInfo) {
        Assert.notNull(majorService.getById(classInfo.getMajorId()), "专业不存在");
        // TODO: 待校验用户是否为 辅导员/班主任
        Assert.notNull(userService.getById(classInfo.getCounselorId()), "辅导员不存在");
        Assert.notNull(userService.getById(classInfo.getHeadTeacherId()), "班主任不存在");
        Assert.isTrue(updateById(classInfo), "更新失败");
    }

}
