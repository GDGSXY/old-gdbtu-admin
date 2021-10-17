package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Teacher;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.enums.RoleLevelEnum;
import cn.edu.gdbtu.admin.domain.user.repository.dao.TeacherDao;
import cn.edu.gdbtu.admin.service.user.TeacherService;
import cn.edu.gdbtu.admin.service.user.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {

    private final UserService userService;

    @Override
    public IPage<Teacher> searchByConditions(SearchPagingQuery query, Long academyId) {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<Teacher>()
                .eq(academyId != null, Teacher::getAcademyId, academyId)
                .likeRight(query.getSearch() != null, Teacher::getName, query.getSearch());
        return getBaseMapper().selectPage(query.toPage(), wrapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Teacher> getAllCounselorByAcademyId(long academyId) {
        List<User> users = userService.getAllByRoleLevel(RoleLevelEnum.COUNSELOR);
        List<Long> userIds = users.stream().map(BaseEntity::getId).toList();
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<Teacher>()
                .eq(Teacher::getAcademyId, academyId)
                .in(Teacher::getUserId, userIds);
        return list(wrapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Teacher> getAllHeadTeacherByAcademyId(long academyId) {
        List<User> users = userService.getAllByRoleLevel(RoleLevelEnum.HEAD_TEACHER);
        List<Long> userIds = users.stream().map(BaseEntity::getId).toList();
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<Teacher>()
                .eq(Teacher::getAcademyId, academyId)
                .in(Teacher::getUserId, userIds);
        return list(wrapper);
    }

}
