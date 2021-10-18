package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.enums.RoleLevelEnum;
import cn.edu.gdbtu.admin.domain.user.repository.dao.UserDao;
import cn.edu.gdbtu.admin.service.user.RoleService;
import cn.edu.gdbtu.admin.service.user.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    /**
     * TODO: 临时方案
     */
    private static final Long DEFAULT_STUDENT_ROLE = 7L;

    private static final Long DEFAULT_TEACHER_ROLE = 6L;

    private static final String DEFAULT_USER_PASSWORD = "123456";

    private final RoleService roleService;

    /**
     * {@inheritDoc}
     */
    @Override
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username);
        return getBaseMapper().selectOne(wrapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IPage<User> searchByCondition(SearchPagingQuery query) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .likeRight(query.getSearch() != null, User::getUsername, query.getSearch());
        return getBaseMapper().selectPage(query.toPage(), wrapper);
    }

    @Override
    public List<User> getAllByRoleLevel(RoleLevelEnum roleLevel) {
        List<Role> roles = roleService.getAllByRoleLevel(roleLevel);
        List<Long> roleIds = roles.stream().map(BaseEntity::getId).toList();
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .in(User::getRoleId, roleIds);
        return list(wrapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(String pinyinName) {
        User user = new User()
                .setUsername(pinyinName)
                .setPassword(DEFAULT_USER_PASSWORD)
                .setSalt("")
                .setRoleId(DEFAULT_STUDENT_ROLE);
        getBaseMapper().insert(user);
        return user;
    }

    @Override
    public User createTeacher(String name) {
        User user = new User()
                .setUsername(name)
                .setPassword(DEFAULT_USER_PASSWORD)
                .setSalt("")
                .setRoleId(DEFAULT_TEACHER_ROLE);
        getBaseMapper().insert(user);
        return user;
    }

    @Override
    public void updateUser(User user) {
        Assert.isTrue(updateById(user), "更新失败");
    }

}
