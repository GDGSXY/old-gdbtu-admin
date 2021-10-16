package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.repository.dao.UserDao;
import cn.edu.gdbtu.admin.service.user.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    /**
     * TODO: 临时方案
     */
    private static final Long DEFAULT_STUDENT_ROLE = 7L;

    private static final String DEFAULT_USER_PASSWORD = "123456";

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

}
